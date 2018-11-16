package com.yiscn.service.impl;

import com.yiscn.common.bean.CommonConfig;
import com.yiscn.entity.ScMatchConfig;
import com.yiscn.entity.ScMatchConfigExample;
import com.yiscn.mapper.ScMatchConfigMapper;
import com.yiscn.service.IScMatchConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    排位区域配置
 *
 * @author wangj
 * @date 2018/7/18 15:19
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scMatchConfigServiceImpl")
public class ScMatchConfigServiceImpl implements IScMatchConfigService {

    @Autowired(required = false)
    private ScMatchConfigMapper scMatchConfigMapper;
    @Autowired
    private CommonConfig commonConfig;

    /**
     * 排位分区个数
     */
    private static final Integer MATCH_SIZE = 4;

    @Override
    public List<ScMatchConfig> getList() {
        ScMatchConfigExample example = new ScMatchConfigExample();
        final List<ScMatchConfig> scMatchConfigs = scMatchConfigMapper.selectByExample(example);
        return scMatchConfigs;
    }

    @Override
    public Integer bathUpdate(List<ScMatchConfig> scMatchConfigs) {
        scMatchConfigs.stream().forEach(e ->{
            ScMatchConfigExample example = new ScMatchConfigExample();
            example.createCriteria().andIdEqualTo(e.getId());
            scMatchConfigMapper.updateByExample(e, example);
        });
        Map<Integer,ScMatchConfig> map = new HashMap<>(4);
        AtomicInteger n = new AtomicInteger(1);
        getList().stream().forEach(e -> {map.put(n.get(),e);n.getAndAdd(1);});

        commonConfig.setScMatchConfigs(map);
        return scMatchConfigs.size();
    }

    @Override
    public Integer update(ScMatchConfig scMatchConfig) {
        ScMatchConfigExample example = new ScMatchConfigExample();
        example.createCriteria().andIdEqualTo(scMatchConfig.getId());
        int i = scMatchConfigMapper.updateByExample(scMatchConfig, example);
        if(i > 0){
            commonConfig.getScMatchConfigs().put(scMatchConfig.getId(),scMatchConfig);
            return i;
        }
        return 0;
    }
}
