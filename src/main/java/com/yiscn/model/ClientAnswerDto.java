package com.yiscn.model;

import lombok.Data;

/**
 *
 *    客户端答题类
 *
 * @author wangj
 * @date 2018/7/10 11:06
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
public class ClientAnswerDto {

    Integer uid;

    Integer num;

    Integer answer;

    Integer ansTime;

    Integer score;

    Boolean yes;

    /**
     * 计算答题用时
     * @return
     */
    /*public Integer time(){
        return (this.endTime-this.curTime)/1000;
    }*/
}
