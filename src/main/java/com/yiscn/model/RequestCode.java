package com.yiscn.model;

/**
 *
 *    接收客户端消息状态码
 *
 * @author wangj
 * @date 2018/7/6 14:24
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public enum RequestCode {

    /**
     * 错误消息
     */
    ERRO_ONLINE(0,"错误消息"),
    /**
     * 开始匹配
     */
    BEGIN_QUALIFYING(1,"开始匹配"),

    /**
     * 客户端答题
     */
    CLIENT_ANSWER(2,"客户端答题"),

    /**
     * 客户端主动拉取结果
     */
    GET_RESULT(3,"客户端主动拉取结果");

    private Integer code;

    private String message;

    RequestCode(Integer code, String message) {
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
