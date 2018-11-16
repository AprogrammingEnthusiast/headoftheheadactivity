package com.yiscn.socket;

import com.yiscn.common.util.JsonUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.model.RequestMessage;
import com.yiscn.model.ResponseCode;
import com.yiscn.model.ResponseMessage;
import com.yiscn.model.Room;
import com.yiscn.service.IPvpService;
import com.yiscn.util.AreaMathUtil;
import com.yiscn.util.RoomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *    排位赛PvP连接
 *
 * @author wangj
 * @date 2018/7/6 14:32
 * Life is so short,do something to make yourself happy,such as coding
 */
@ServerEndpoint(value = "/websocket/{uid}/{areaId}")
@Component
public class QualifyingSocket {

    public QualifyingSocket(){
        //System.out.println("我被创建啦");
    }

    /**
     * 由于websocket在spring中会在没有此客户端连接时创建新的对象
     * 所以依赖注入无法使用，只有使用动态注入的方式手动获取
     */
    private static IPvpService pvpService;

    /*private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        QualifyingSocket.applicationContext = applicationContext;
    }*/

    private static final Integer RAND_UP_SIZE = 1;
    private static final Integer MATCH_TIME = 10;
    /**
     * 用于整合最有在线用户
     */
    private static CopyOnWriteArraySet<QualifyingSocket> sessions = new CopyOnWriteArraySet<QualifyingSocket>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    private Session session;
    private Integer uid;
    /**
     * 选择大区
     * 1.新手起步
     * 2.熟手锻炼
     * 3.头脑达人
     * 4.旷世奇才
     * 0.随机匹配
     */
    private Integer areaId;
    private volatile Integer roomId = 0;

    @Autowired
    public QualifyingSocket(IPvpService pvpService){
        QualifyingSocket.pvpService = pvpService;
    }
    /**
     * 连接建立成功调用的方法
     **/
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") Integer uid,
                       @PathParam("areaId")Integer areaId) {
        System.out.println("==========open"+uid);
        this.session = session;
        this.uid = uid;
        this.areaId = areaId;
        sessions.add(this);
        sendMessage(JsonUtil.toJSONString(new ResponseMessage(ResponseCode.OPEN_ONLINE.getCode(),null)));
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println("close =================================="+this.getUid());
        //如果已经匹配到房间要清除房间
        if(getIsRoom()){
            sendToRoomOther(this.roomId,JsonUtil.toJSONString(
                    new ResponseMessage(ResponseCode.BROKEN_LINE.getCode(),null)));

            RoomUtil.removeUser(getRoomId(),this);
        }
        //从set中删除
        //AreaMathUtil.getAreaMath(areaId).removeSocket(this);
        sessions.remove(this);
        /*onlineSub();*/
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * */
    @OnMessage
    public void onMessage(String message, Session session) {
        /*pvpService = (PvpServiceImpl)applicationContext.getBean("pvpServiceImpl");
        System.out.println("我注入啦");*/
        RequestMessage requestMessage = JsonUtil.toBean(message, RequestMessage.class);
        /**
         * 消息处理
         */
        try {
            pvpService.start(requestMessage, this);
        } catch (IOException e) {
            e.printStackTrace();
            SpringBootLogger.error("收到客户端消息后调用的方法:"+e);
        }

    }

    /**
     * 发生错误时调用
     * @param error
     */
    @OnError
    public void onError(Throwable error){
        System.out.println("erro ==================================");
        if(getIsRoom()){

            sendToRoomOther(this.roomId,JsonUtil.toJSONString(
                    new ResponseMessage(ResponseCode.BROKEN_LINE.getCode(),null)));

            RoomUtil.removeUser(getRoomId(),this);
        }
        //从set中删除
        //AreaMathUtil.getAreaMath(areaId).removeSocket(this);
        sessions.remove(this);
        error.printStackTrace();
    }

    /**
     * 匹配方法
     * @param socket
     * @return
     */
    public void matching(QualifyingSocket socket) {
        Integer size;
        Random rand = new Random();
        QualifyingSocket enemy;
        int num = 1;
        //匹配真人逻辑设置10秒超时时间
        while (num <= MATCH_TIME) {
            //判断连接是否失效||验证自己是否在房间
            if(!socket.getOnline() || getIsRoom()){
                return;
            }
            size = AreaMathUtil.getAreaMath(socket.getAreaId()).onlionSize();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                SpringBootLogger.error("匹配方法休眠报错"+e);
            }

            num++;

            if(size > RAND_UP_SIZE){
                Integer i = rand.nextInt(size) + RAND_UP_SIZE;
                enemy = AreaMathUtil.getAreaMath(socket.getAreaId()).getSocket(i);
                if(enemy == null){
                    continue;
                }
                boolean isMe = socket.getUid().equals(enemy.getUid());
                //判断是否匹配的是自己||验证敌人是否在房间
                if(isMe || enemy.getIsRoom()) {
                    continue;
                }
                //验证自己是否在房间
                if(getIsRoom()){
                    return;
                }
                //将敌人移除匹配集合
                AreaMathUtil.getAreaMath(socket.getAreaId()).removeSocket(enemy);
                //将自己自移除匹配集合
                AreaMathUtil.getAreaMath(socket.getAreaId()).removeSocket(socket);
                //加入房间
                Integer joinRoom = pvpService.joinRoom(socket, enemy);
                if(joinRoom <= 0){
                    //如果未能添加房间，将把双方添加回匹配队列重新匹配
                    AreaMathUtil.getAreaMath(socket.getAreaId()).addSocket(socket);
                    AreaMathUtil.getAreaMath(socket.getAreaId()).addSocket(enemy);
                    continue;
                }
                System.out.println("匹配成功：主场"+socket.getUid()+"客场"+enemy.getUid());
                return;
            }
        }
        //10秒未匹配到进入机器人逻辑
        if(socket.getOnline() || !getIsRoom()) {
            AreaMathUtil.getAreaMath(socket.getAreaId()).removeSocket(socket);
        }
    }

    /**
     * 解析错误返回
     * @return
     */
    public void erroMessage()  {

        sendMessage(JsonUtil.toJSONString(
                new ResponseMessage(ResponseCode.ERRO_ONLINE.getCode(),null)));
    }

    /**
     * 给自己发消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) {
        try {
            if (sessions.size() != 0) {
                for (QualifyingSocket s : sessions) {
                    if (s == this) {
                        // 判断是否为终端信息。如果是终端信息则查询数据库获取detail
                        s.session.getBasicRemote().sendText(message);
                    }
                }
            }
        } catch (IOException e) {
            SpringBootLogger.error("socket发送消息失败"+e);
            e.printStackTrace();
        }
    }

    /**
     * 给房间里的所有人发消息
     * @param roomId
     * @param message
     */
    public static void sendToRoomEveryOne(Integer roomId,String message){
        Room room = RoomUtil.getRoom(roomId);
        //给对手发消息
        if(room.getAwayUser() != null) {
            room.getAwayUser().sendMessage(message);
        }
        //给自己发消息
        if(room.getHomeUser() != null) {
            room.getHomeUser().sendMessage(message);
        }
    }

    /**
     * 给房间里的另一个人发消息
     *
     */
    public void sendToRoomOther(Integer roomId,String message){
        final Room room = RoomUtil.room.get(roomId);
        if(room.getHomeUser() != null && room.getAwayUser() != null) {
            if (room.getHomeUser().uid.equals(this.uid)) {
                room.getAwayUser().sendMessage(message);
            } else {
                room.getHomeUser().sendMessage(message);
            }
        }
    }

    /**
     * 是否在线
     * @return
     */
    public Boolean getOnline() {

        if (sessions.size() != 0) {
            for (QualifyingSocket s : sessions) {
                if (s == this) {
                    // 判断是否为终端信息。如果是终端信息则查询数据库获取detail
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 改变房间状态
     */
    public Integer changeRoomId(Integer roomId){
        w.lock();
        try {
            if(getOnline()) {
                setRoomId(roomId);
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            SpringBootLogger.error("改变房间状态:"+e);
        }finally{
            w.unlock();   //释放锁
        }
        return 1;
    }

    /**
     * 获取房间状态
     */
    public Boolean getIsRoom(){
        r.lock();
        Boolean result = null;
        try {
            result = this.roomId != null && this.roomId != 0;
        }catch (Exception e){
            e.printStackTrace();
            SpringBootLogger.error("获取房间状态:"+e);
        }finally{
            r.unlock();   //释放锁
        }
        return result;
    }

    public Integer getUid() {
        return uid;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setPvpService(IPvpService pvpService) {
        this.pvpService = pvpService;
    }
}
