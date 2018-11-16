package com.yiscn.common.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 *   带返回值对象的返回数据结构
 *
 * @author wangj
 * @date 2018/7/17 9:40
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ResultWarp<T> extends Result {
    public T data;

    public ResultWarp(T content) {
        this.setCode(1);
        this.data = content;
        this.setMsg("成功");
    }

    public ResultWarp(StatusCode statusCode,T content) {
        this.data = content;
        this.setCode(statusCode.getCode());
        this.setMsg(statusCode.getMessage());
    }
}

