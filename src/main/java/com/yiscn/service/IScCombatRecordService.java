package com.yiscn.service;

import com.yiscn.common.bean.PageBean;
import com.yiscn.entity.ScCombatRecord;
import com.yiscn.model.Room;

/**
 * 比赛记录表
 *
 * @param
 * @author wangj
 * @date 2018/7/10 16:32
 * @return Life is so short,do something to make yourself happy,such as coding
 */
public interface IScCombatRecordService {

    /**
     * 添加一条对战记录
     * @param scCombatRecord
     */
    void add(ScCombatRecord scCombatRecord);

    /**
     * 将对战房间中的对战记录数据添加至数据库中
     * @param room
     * @param type
     * @throws Exception
     */
    void addForRoom(Room room, Integer type) throws Exception;

    /**
     * 根据条件查询某一用户的对战信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageBean<ScCombatRecord> getPageBean(Integer userId,Integer areaId,Integer relust,
                                         Integer pageNum,Integer pageSize);

}
