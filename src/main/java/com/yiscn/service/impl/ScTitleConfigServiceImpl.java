package com.yiscn.service.impl;

import com.yiscn.common.bean.CommonConfig;
import com.yiscn.entity.ScMatchConfig;
import com.yiscn.entity.ScMatchConfigExample;
import com.yiscn.entity.ScTitleConfig;
import com.yiscn.entity.ScTitleConfigExample;
import com.yiscn.mapper.ScTitleConfigMapper;
import com.yiscn.service.IScTitleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    称号配置
 *
 * @author wangj
 * @date 2018/7/18 15:19
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scTitleConfigServiceImpl")
public class ScTitleConfigServiceImpl implements IScTitleConfigService {

    @Autowired(required = false)
    private ScTitleConfigMapper scTitleConfigMapper;
    @Autowired
    private CommonConfig commonConfig;

    @Override
    public List<ScTitleConfig> getList() {
        ScTitleConfigExample example = new ScTitleConfigExample();
        //example.setOrderByClause(" min_grade ");
        return scTitleConfigMapper.selectByExample(example);
    }

    @Override
    public Integer bathUpdate(List<ScTitleConfig> scTitleConfigs) {

        scTitleConfigs.stream().forEach(e ->{
            ScTitleConfigExample example = new ScTitleConfigExample();
            example.createCriteria().andIdEqualTo(e.getId());
            scTitleConfigMapper.updateByExample(e, example);
        });

        commonConfig.putTitleConfig();
        return scTitleConfigs.size();
    }

    @Override
    public Integer update(ScTitleConfig scTitleConfig) {
        ScTitleConfigExample example = new ScTitleConfigExample();
        example.createCriteria().andIdEqualTo(scTitleConfig.getId());
        int i = scTitleConfigMapper.updateByExample(scTitleConfig, example);
        if(i > 0){
            commonConfig.putTitleConfig();
            return 1;
        }
        return 0;
    }

    @Override
    public Integer add(ScTitleConfig scTitleConfig) {
        return null;
    }

    @Override
    public Integer remove(Integer id) {
        return null;
    }
}
