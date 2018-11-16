package com.yiscn.service;

import com.yiscn.entity.ScMatchConfig;

import java.util.List;

/**
 *
 *    排位区域配置
 *
 * @author wangj
 * @date 2018/7/18 14:37
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScMatchConfigService {

    List<ScMatchConfig> getList();

    Integer bathUpdate(List<ScMatchConfig> scMatchConfigs);

    Integer update(ScMatchConfig scMatchConfig);
}
