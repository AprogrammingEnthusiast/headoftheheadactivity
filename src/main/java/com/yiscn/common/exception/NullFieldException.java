package com.yiscn.common.exception;

/**
 *
 *    空字段异常
 *
 * @author wangj
 * @date 2018/7/6 11:21
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class NullFieldException extends Exception {

    public NullFieldException (String msg){
        super(msg);
    }
}
