package com.yiscn.common.exception;

/**
 *
 *    数据库不存在该记录异常
 *
 * @author wangj
 * @date 2018/7/6 11:21
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class DbNoExistException extends Exception{
    public DbNoExistException(String msg){
        super(msg);
    }
}
