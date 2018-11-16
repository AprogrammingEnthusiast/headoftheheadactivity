package com.yiscn.common.http;

/**
 * @Author: DengLibin
 * @Description: http请求返回状态码非200异常
 * @DateTime: 9:16 2018/4/17 0017
 */
public class HttpStatusCodeException extends Exception {
    public HttpStatusCodeException(String msg){
        super(msg);
    }
}
