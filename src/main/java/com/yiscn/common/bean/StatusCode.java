package com.yiscn.common.bean;

/**
 *
 * 接口返回结果状态码
 *
 * @author wangj
 * @date 2018/7/6 11:40
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public enum StatusCode {

    /**
     * 操作失败
     */
    FAIL_CODE(0,"操作失败"),

    /**
     * 成功状态
     */
    SUCCESS_CODE(1,"操作成功"),

    /**
     * 操作失败,且异常被捕获
     */
    CATCH_EXCEPTION_CODE(2,"操作失败,且异常被捕获"),

    /**
     * 参数异常
     */
    PARAMETER_EXCEPTION(3,"参数异常");

    /**
     * 成员变量
     */
    private Integer code;

    private String message;

    /**
     * 构造方法
      * @param code
     * @param message
     * @return
     */
    StatusCode(Integer code, String message) {
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
