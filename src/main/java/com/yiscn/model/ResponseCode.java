package com.yiscn.model;

/**
 *
 *    发送服务端消息状态码
 *
 * @author wangj
 * @date 2018/7/6 14:24
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public enum  ResponseCode {

    /**
     * 错误消息
     */
    ERRO_ONLINE(0,"错误消息"),

    /**
     * 上线连接成功
     */
    OPEN_ONLINE(1,"上线连接成功"),

    /**
     * 匹配成功
     */
    MATCHING_SUCCESS(2,"匹配成功"),

    /**
     * 对方答题
     */
    OTHER_ANSWER(3,"对方答题"),

    /**
     * 答题结束结算
     */
    MATCH_OVER(4,"答题结束"),

    /**
     * 对方断线
     */
    BROKEN_LINE(5,"对方断线");

    private Integer code;

    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;

    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
