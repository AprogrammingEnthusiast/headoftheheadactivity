package com.yiscn.service.impl;

import com.yiscn.common.bean.CommonConfig;
import com.yiscn.entity.*;
import com.yiscn.mapper.ScSubjectTypeMapper;
import com.yiscn.service.IScSubjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    题目类型配置
 *
 * @author wangj
 * @date 2018/7/18 15:20
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scSubjectTypeServiceImpl")
public class ScSubjectTypeServiceImpl implements IScSubjectTypeService {

    @Autowired(required = false)
    private ScSubjectTypeMapper scSubjectTypeMapper;
    @Autowired
    private CommonConfig commonConfig;

    @Override
    public List<ScSubjectType> getList() {
        ScSubjectTypeExample example = new ScSubjectTypeExample();
        return scSubjectTypeMapper.selectByExample(example);
    }

    @Override
    public Integer BathUpdate(List<ScSubjectType> scSubjectTypes) {
        scSubjectTypes.stream().forEach(e ->{
            ScSubjectTypeExample example = new ScSubjectTypeExample();
            example.createCriteria().andIdEqualTo(e.getId());
            scSubjectTypeMapper.updateByExample(e, example);
        });
        commonConfig.putSubjectTypeConfig();
        return scSubjectTypes.size();
    }

    @Override
    public Integer updateName(ScSubjectType scSubjectType) {
        ScSubjectTypeExample example = new ScSubjectTypeExample();
        example.createCriteria().andIdEqualTo(scSubjectType.getId());
        int i = scSubjectTypeMapper.updateByExample(scSubjectType, example);
        if(i > 0){
            commonConfig.putSubjectTypeConfig();
            return i;
        }
        return i;
    }
}
