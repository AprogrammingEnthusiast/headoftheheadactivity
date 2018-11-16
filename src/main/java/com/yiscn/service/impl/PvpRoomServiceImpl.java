package com.yiscn.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.yiscn.common.bean.CommonConfig;
import com.yiscn.common.util.DateUtil;
import com.yiscn.common.util.JsonUtil;
import com.yiscn.entity.ScMatchConfig;
import com.yiscn.model.*;
import com.yiscn.service.IPvpRoomService;
import com.yiscn.service.IQueueService;
import com.yiscn.service.IScCombatRecordService;
import com.yiscn.socket.QualifyingSocket;
import com.yiscn.util.RoomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *    房间对战处理
 *
 * @author wangj
 * @date 2018/7/10 9:37
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("pvpRoomServiceImpl")
public class PvpRoomServiceImpl implements IPvpRoomService {

    @Autowired
    private IScCombatRecordService scCombatRecordService;
    @Autowired
    private IQueueService queueService;
    @Autowired
    private CommonConfig commonConfig;

    private static final Integer PVP_TYPE = 1;
    /**
     * 答题结束表示
     */
    private static final Integer ANSWER_OVER = 5;

    /**
     * 处理答题逻辑
     * @param socket
     * @param clientAnswerDto
     */
    @Override
    public void clientAnswer(QualifyingSocket socket, ClientAnswerDto clientAnswerDto) {
        if (!clientAnswerDto.getUid().equals(socket.getUid())){
            socket.erroMessage();
        }
        Room room = RoomUtil.getRoom(socket.getRoomId());
        //计算得分
        countScore(room,socket,clientAnswerDto);
        //正常答题结束，返回结果，数据入库
        if(ANSWER_OVER.equals(clientAnswerDto.getNum())){
            if(socket.getUid().equals(room.getHomeUser().getUid())){
                room.setHomeOver(true);
                if(room.getAwayOver()){
                    MatchOver(room);
                    RoomUtil.removeRoom(socket.getRoomId());
                }
            }else {
                room.setAwayOver(true);
                if(room.getHomeOver()){
                    MatchOver(room);
                    RoomUtil.removeRoom(socket.getRoomId());
                }
            }
        }
    }

    /**
     * 主动获取比赛结果并且入库
     * @param socket
     */
    @Override
    public void getResult(QualifyingSocket socket) {
        Room room = RoomUtil.getRoom(socket.getRoomId());
        matchOverToRoom(room);
        if(room.getHomeUser() != null) {
            room.getHomeUser().setRoomId(0);
        }
        if(room.getAwayUser() != null) {
            room.getAwayUser().setRoomId(0);
        }
        room.setEndTime(DateUtil.getNowDateString());
        queueService.putTask(()->
                scCombatRecordService.addForRoom(room, PVP_TYPE)
        );
    }

    /**
     * 答题结束，返回结果，数据入库
     * @param room
     */
    private void MatchOver(Room room) {
        matchOverToRoom(room);
        if(room.getHomeUser() != null) {
            room.getHomeUser().setRoomId(0);
        }
        if(room.getAwayUser() != null) {
            room.getAwayUser().setRoomId(0);
        }
        room.setEndTime(DateUtil.getNowDateString());
        queueService.putTask(()->
                    scCombatRecordService.addForRoom(room, PVP_TYPE)
        );
    }

    /**
     * 答题结束，向双方推送比赛结果
     */
    private void matchOverToRoom(Room room){
        final MatchOverVo convert = convert(room);
        //答题结束像双方发送结果信息
        QualifyingSocket.sendToRoomEveryOne(room.getRoom_id(),JsonUtil.toJSONString(
                new ResponseMessage(ResponseCode.MATCH_OVER.getCode(),convert)));
    }

    /**
     * 比赛结束对象封装
     * @param room
     * @return
     */
    private MatchOverVo convert(Room room){
        MatchOverVo matchOverVo = new MatchOverVo();
        matchOverVo.setRoomId(room.getRoom_id());
        matchOverVo.setHomeUId(room.getHomeUser().getUid());
        matchOverVo.setAwayUId(room.getAwayUser().getUid());
        Integer homeScore = room.getHomeScore();
        Integer awayScore = room.getAwayScore();
        matchOverVo.setHomeScore(homeScore);
        matchOverVo.setAwayScore(awayScore);
        matchOverVo.setBeginTime(room.getBeginTime());
        matchOverVo.setEndTime(room.getEndTime());

        //获取赛区
        final Integer areaId = room.getAreaId();
        final ScMatchConfig scMatchConfig = commonConfig.getScMatchConfigs().get(areaId);
        final Integer win = scMatchConfig.getRewardExperience();
        final Integer flat = win/2;

        if(homeScore > awayScore){
            //主胜
            matchOverVo.setHomeExperience(win);
        }else if(homeScore.equals(awayScore)){
            //平局
            matchOverVo.setHomeExperience(flat);
            matchOverVo.setAwayExperience(flat);
        }else {
            //客胜
            matchOverVo.setAwayExperience(win);
        }

        return matchOverVo;
    }

    /**
     * 计算得分
     */
    private void countScore(Room room,QualifyingSocket socket,ClientAnswerDto clientAnswerDto){
        if(clientAnswerDto.getYes()) {
            room.addScore(socket.getUid(), clientAnswerDto.getScore());
        }
        answerToOther(socket,clientAnswerDto);
    }

    /**
     * 封装答题传输对象，像对手发送答题结果
     * @param socket
     * @param clientAnswerDto
     */
    private void answerToOther(QualifyingSocket socket,ClientAnswerDto clientAnswerDto){
        final ServerAnswerVo serverAnswerVo = new ServerAnswerVo(clientAnswerDto.getUid(), clientAnswerDto.getNum(), clientAnswerDto.getAnswer(),
                clientAnswerDto.getScore(), clientAnswerDto.getYes());
        ResponseMessage responseMessage = new ResponseMessage(ResponseCode.OTHER_ANSWER.getCode(), serverAnswerVo);
        socket.sendToRoomOther(socket.getRoomId(), JsonUtil.toJSONString(responseMessage));
    }
}
