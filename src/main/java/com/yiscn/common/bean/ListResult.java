package com.yiscn.common.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangj
 * @date 2018/7/17 11:53
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ListResult<T> extends Result {
    /**
     * 总数
     */
    private Integer total;
    /**
     * 记录
     */
    private T rows;
    /**
     * 合计
     */
    private T footer;

    public ListResult(Integer code, String msg, Integer total, T rows) {
        //编码和信息
        super(code, msg);
        this.total = total;
        this.setRows(rows);
    }
    public ListResult(Integer code, String msg,  T rows) {
        //编码和信息
        super(code, msg);
        this.setRows(rows);
    }

    public ListResult(Integer code, String msg, Integer total, T rows,T footer) {
        //编码和信息
        super(code, msg);
        this.total = total;
        this.setFooter(footer);
        this.setRows(rows);
    }

    public ListResult(Integer total,T rows) {
        this.setCode(1);
        this.setRows(rows);
        this.setTotal(total);
        this.setMsg("ok");
    }
}
