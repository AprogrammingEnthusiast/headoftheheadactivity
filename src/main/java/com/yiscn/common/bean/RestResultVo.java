package com.yiscn.common.bean;

/**
 *
 *    rest请求返回数据封装
 *
 * @author wangj
 * @date 2018/7/6 11:37
 * Life is so short,do something to make yourself happy,such as coding
 */
public class RestResultVo<T> {

    private Integer statusCode = 200;
    private String statusMsg = "SUCCESS";
    private T data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
