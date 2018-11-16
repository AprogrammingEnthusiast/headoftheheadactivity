package com.yiscn.service;

import com.yiscn.common.bean.PageBean;
import com.yiscn.entity.ScExperience;
import com.yiscn.model.ScUserExperienceVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 *    用户经验表
 *
 * @author wangj
 * @date 2018/7/26 10:33
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScExperienceservice {

    /**
     * 历史排名数据入库
     * ps：通过定时器每月月初的0.0时，将用户数据导入至历史用户经验表
     * 并且将用户表中所有用户数据清空只保留基础数据
     * @return
     */
    Integer bacthAdd();

    /**
     * 根据月份查询此月用户排行
     * @param mouth
     * @return
     */
    PageBean<ScUserExperienceVo> getPageBean(Integer mouth, Integer pageNum, Integer pageSize);

    /**
     * 查询某用户历史排名
     * @param mouth
     * @param userId
     * @return
     */
    ScUserExperienceVo getOneOld(Integer mouth,Integer userId);

    /**
     * 查询某用户历史排名
     * @param mouth
     * @param userId
     * @return
     */
    List<ScExperience> getOne(Integer mouth,Integer userId);

    /**
     * 历史排名导出
     * @param mouth
     * @param size
     * @param classPathRealPath
     * @return
     */
    String getPassDreamexport(Integer mouth, Integer size, String classPathRealPath);
}
