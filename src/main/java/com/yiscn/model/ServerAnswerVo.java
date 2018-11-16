package com.yiscn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 *    服务端返回答题结果
 *
 * @author wangj
 * @date 2018/7/10 13:59
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@AllArgsConstructor
public class ServerAnswerVo {

    Integer uid;

    Integer num;

    Integer answer;

    Integer score;

    Boolean yes;
}
