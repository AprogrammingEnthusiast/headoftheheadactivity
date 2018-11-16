package com.yiscn.service;

import com.yiscn.common.bean.PageBean;
import com.yiscn.entity.ScRobotConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 *
 * @author wangj
 * @date 2018/7/23 16:51
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScRobotService {

    /**
     * 获取对应赛区全部机器人数据
     * @return
     */
    Map<Integer,Set<ScRobotConfig>> getConfig();

    /**
     * 获取一个机器人
     * @param id
     * @return
     */
    ScRobotConfig getOne(Integer id);

    /**
     * 通过机器人类型获取机器人集合（只获取已启用的）
     * @param robotType
     * @return
     */
    List<ScRobotConfig> getListByType(Integer robotType);

    /**
     * 添加机器人
     * @param scRobotConfig
     * @return
     */
    Integer add(ScRobotConfig scRobotConfig);

    /**
     * 修改机器人
     * @param scRobotConfig
     * @return
     */
    Integer update(ScRobotConfig scRobotConfig) throws Exception;

    /**
     * 根据所属区域和是否启用获取机器人类表
     * @return
     */
    PageBean<ScRobotConfig> getPageBean(Boolean isUse,Integer areaId,Integer pageNum,Integer pageSize);

    /**
     * 删除机器人
     * @param id
     * @return
     */
    Integer remove(Integer id);

    /**
     * 根据赛区随意获取一个已启用的机器人
     * @param areaId
     * @return
     */
    ScRobotConfig randGetOne(Integer areaId);
}
