package com.yiscn.service;

import com.yiscn.model.UpdateModelDto;
import com.yiscn.model.UpdateModelVo;

import java.util.List;

/**
 *
 *    修改非数据库配置接口
 *
 * @author wangj
 * @date 2018/7/30 9:56
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScCommonConfigService {

    /**
     * 开启或停止游戏模块
     * @param updateModelDto
     * @return
     */
    Integer updateModel(UpdateModelDto updateModelDto);

    /**
     * 获取模块开启配置列表
     * @return
     */
    List<UpdateModelVo> getList();

    Integer bathUpdateModel(List<UpdateModelDto> updateModelDtos);
}
