package com.yiscn.service;

import com.yiscn.entity.ScTitleConfig;

import java.util.List;

/**
 *
 *    称号配置
 *
 * @author wangj
 * @date 2018/7/18 15:10
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScTitleConfigService {

    /**
     * 获取称谓列表
     * @return
     */
    List<ScTitleConfig> getList();

    /**
     * 批量修改称谓
     * @param scTitleConfigs
     * @return
     */
    Integer bathUpdate(List<ScTitleConfig> scTitleConfigs);

    /**
     * 修改称谓
     * @param scTitleConfig
     * @return
     */
    Integer update(ScTitleConfig scTitleConfig);

    /**
     * 添加称谓
     * @param scTitleConfig
     * @return
     */
    Integer add(ScTitleConfig scTitleConfig);

    /**
     * 删除称谓
     * @param id
     * @return
     */
    Integer remove(Integer id);
}
