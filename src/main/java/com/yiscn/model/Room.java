package com.yiscn.model;

import com.yiscn.common.util.DateUtil;
import com.yiscn.socket.QualifyingSocket;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 *
 *    排位pvp对战房间
 *
 * @author wangj
 * @date 2018/7/6 16:03
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@Entity
public class Room {

    private Integer room_id;

    /**
     * 主场是否答题结束
     */
    private Boolean homeOver = false;

    /**
     * 主场是否答题结束
     */
    private Boolean awayOver = false;

    /**
     * 主场用户
     */
    private QualifyingSocket homeUser;

    /**
     * 客场用户
     */
    private QualifyingSocket awayUser;

    /**
     * 题目
     */
    private final List<SubjectVo> subjects;

    /**
     * 主场得分
     */
    private Integer homeScore = 0;

    /**
     * 客场得分
     */
    private Integer awayScore = 0;

    /**
     * 比赛开始时间
     */
    private String beginTime ;

    /**
     * 比赛结束时间
     */
    private String endTime;

    /**
     * 赛区
     */
    private Integer areaId;

    public Room(Integer room_id,QualifyingSocket homeUser,QualifyingSocket awayUser,List<SubjectVo> subjects,
                Integer areaId){
        this.room_id = room_id;
        this.homeUser = homeUser;
        this.awayUser = awayUser;
        this.subjects = subjects;
        this.areaId = areaId;
        beginTime = DateUtil.getNowDateString();
    }

    /**
     * 给自己加分
     * @param score
     */
    public void addScore(Integer uid ,Integer score){
        if(uid.equals(this.homeUser.getUid())){
            homeScore+=score;
        }else {
            awayScore+=score;
        }
    }
}
