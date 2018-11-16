package com.yiscn.common.exception;

/**
 *
 *    后台登录授权异常
 *
 * @author wangj
 * @date 2018/7/6 11:21
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class AuthorizeException extends RuntimeException {

    public AuthorizeException(String msg){
        super(msg);
    }

}
