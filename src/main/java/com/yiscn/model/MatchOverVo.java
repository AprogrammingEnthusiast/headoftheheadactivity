package com.yiscn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 *
 *    匹配结束后返回对象
 *
 * @author wangj
 * @date 2018/7/16 17:30
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchOverVo {

    private Integer roomId;

    /**
     * 主场用户id
     */
    private Integer homeUId;

    /**
     * 主场用户id
     */
    private Integer awayUId;

    /**
     * 主场得分
     */
    private Integer homeScore;

    /**
     * 客场得分
     */
    private Integer awayScore;

    /**
     * 比赛开始时间
     */
    private String beginTime ;

    /**
     * 比赛结束时间
     */
    private String endTime;

    /**
     * 主场增加经验值
     */
    private Integer homeExperience;

    /**
     * 客场增加经验值
     */
    private Integer awayExperience;

}
