package com.yiscn.service;

import com.github.pagehelper.Page;
import com.yiscn.common.bean.PageBean;
import com.yiscn.entity.ScUser;
import com.yiscn.model.ScUserDto;
import io.swagger.models.auth.In;

import java.util.List;

public interface IScUserService {

    /**
     * 根基id获取一个用户
     * @param id
     * @return
     */
    ScUser get(Integer id);

    /**
     * 添加用户
     * @param scUserDto
     * @return
     */
    Integer add(ScUserDto scUserDto);

    /**
     * 修改用户数据，不用于暴露于前端使用，仅用于后台逻辑处理
     * @param scUser
     * @return
     */
    Integer update(ScUser scUser) throws Exception;

    /**
     * 按照等级，经验，总场次并且总场次不等于o的顺序排序查询所有用户
     * @return
     */
    List<ScUser> getList();

    /**
     * 批量将对象重置
     * @param scUsers
     * @return
     */
    Integer batchUpdateTo0(List<ScUser> scUsers);

    /**
     * 根据openId获取用户信息
     * @param openId
     * @return
     */
    ScUser getByOpenId(String openId);

    /**
     * 按照等级，经验，总场次并且总场次不等于o的顺序排序查询所有用户
     * @return
     */
    PageBean<ScUser> getPageBean(String nickName, String openId, Integer level, Integer pageNum, Integer pageSize);
}
