package com.yiscn.common.bean;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页封装
 * Created by DengLibin on 2017/8/7.
 */
public class PageBean<T> {
    private int pageNum; //页数
    private int pageSize; //每页大小
    private long total; //总数
    private List<T> list; //数据集合

    public PageBean() {
    }
    public PageBean(PageInfo<T> pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
