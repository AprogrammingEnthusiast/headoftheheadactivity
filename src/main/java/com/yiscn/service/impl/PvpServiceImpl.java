package com.yiscn.service.impl;

import com.yiscn.common.util.JsonUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.entity.ScUser;
import com.yiscn.model.*;
import com.yiscn.service.*;
import com.yiscn.socket.QualifyingSocket;
import com.yiscn.util.AreaMathUtil;
import com.yiscn.util.RoomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 *
 *    排位对战逻辑处理类
 *
 * @author wangj
 * @date 2018/7/9 9:10
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("pvpServiceImpl")
public class PvpServiceImpl implements IPvpService {

    private static PvpServiceImpl pvpService;

    private PvpServiceImpl(){}

    public static PvpServiceImpl getPvpService(){
        if (pvpService == null) {
            pvpService = new PvpServiceImpl();
        }
        return pvpService;
    }

    @Autowired
    private IScUserService scUserService;
    @Autowired
    private IScSubjectService scSubjectService;
    @Autowired
    private IPvpRoomService pvpRoomService;

    /**
     * 房间id最大值
     */
    private static final Integer MAX_ROOMID = 100000000;

    /**
     * 房间id最小值
     */
    private static final Integer MIN_ROOMID = 999999999;

    /**
     * 开始解析
     * @param requestMessage 客户端的消息对象
     * @param socket
     * @return
     */
    @Override
    public void start(RequestMessage requestMessage, QualifyingSocket socket) {
        //System.out.println("注入成功啦");
        Integer status = requestMessage.getStatus();
        switch (status){
            //排位匹配逻辑
            case 1:
                //加入排队集合
                AreaMathUtil.getAreaMath(socket.getAreaId()).addSocket(socket);
                System.out.println("匹配了==================="+socket.getUid());

                socket.matching(socket);

                break;
            //答题发送答案逻辑
            case 2:
                //解析客户端返回的参数
                final String s = JsonUtil.toJSONString(requestMessage.getData());
                ClientAnswerDto answer;
                answer = JsonUtil.toBean(s,ClientAnswerDto.class);
                pvpRoomService.clientAnswer(socket,answer); break;
            case 3:
                pvpRoomService.getResult(socket);
                break;
            default:socket.erroMessage();break;
        }
    }

    /**
     * 加入房间
     * @param myself
     * @param enemy
     * @return
     */
    @Override
    public Integer joinRoom(QualifyingSocket myself,QualifyingSocket enemy){
        Random random = new Random();
        final Integer roomId  = random.nextInt(MAX_ROOMID)%(MAX_ROOMID-MIN_ROOMID+1) + MIN_ROOMID;
        //将敌人设为在房间中
        Integer addAway = enemy.changeRoomId(roomId);
        if(addAway <= 0){
            return 0;
        }
        //将自己设为在房间中
        Integer addMy = myself.changeRoomId(roomId);
        if(addMy <= 0){
            enemy.changeRoomId(0);
            return -1;
        }
        //随机发题5道
        List<SubjectVo> iusse = iusse(myself.getAreaId());
        final Room room = new Room(roomId, myself, enemy,iusse,myself.getAreaId());
        RoomUtil.room.put(roomId,room);
        matchSuccessResponse(myself,enemy,roomId,iusse);
        return 1;
    }

    /**
     * 随机发题
     * //TODO 缺少发题条件
     */
    private List<SubjectVo> iusse(Integer areaId){
        return scSubjectService.randomIusse(areaId);
    }

    /**
     * 匹配成功后向两边发消息
     * @param myself
     * @param enemy
     * @param roomId
     */
    private void matchSuccessResponse(QualifyingSocket myself,QualifyingSocket enemy,
                                      final Integer roomId,List<SubjectVo> iusse){
        ScUser myUser = scUserService.get(myself.getUid());
        ScUser enemyUser = scUserService.get(enemy.getUid());
        /*iusse.stream().forEach(e -> e.setAnswer(0));*/

        myself.sendMessage(JsonUtil.toJSONString(new ResponseMessage(ResponseCode.MATCHING_SUCCESS.getCode(),new MatchIngSuccessVo(roomId,enemyUser,iusse))));
        enemy.sendMessage(JsonUtil.toJSONString(new ResponseMessage(ResponseCode.MATCHING_SUCCESS.getCode(),new MatchIngSuccessVo(roomId,myUser,iusse))));

    }

    /**
     * 检查客户端是否在房间中
     * @param socket
     * @return
     */
    public Boolean checkIsRoom(QualifyingSocket socket){
        return socket.getIsRoom();
    }
}
