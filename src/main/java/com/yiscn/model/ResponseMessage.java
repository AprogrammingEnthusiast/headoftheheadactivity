package com.yiscn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 *    发送服务端消息
 *
 * @author wangj
 * @date 2018/7/9 9:28
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage implements Serializable{

    private Integer status;

    private Object data;

}
