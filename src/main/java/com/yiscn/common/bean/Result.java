package com.yiscn.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 *    返回基础数据结构
 *
 * @author wangj
 * @date 2018/7/17 9:40
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    /**
     * 返回结果编码
     */
    private Integer code;
    /**
     * 返回字符串
     */
    private String msg;

    public Result(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMessage();
    }
}
