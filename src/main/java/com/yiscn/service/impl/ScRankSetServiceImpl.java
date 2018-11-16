package com.yiscn.service.impl;

import com.yiscn.common.bean.CommonConfig;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.entity.ScRankSet;
import com.yiscn.entity.ScRankSetExample;
import com.yiscn.mapper.ScRankSetMapper;
import com.yiscn.service.IScRankSetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *    排位设置
 *
 * @author wangj
 * @date 2018/7/18 9:54
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scRankSetServiceImpl")
public class ScRankSetServiceImpl implements IScRankSetService {

    @Autowired(required = false)
    private ScRankSetMapper scRankSetMapper;
    @Autowired
    private CommonConfig commonConfig;

    /**
     * 修改排位规则
     * @param scRankSet
     * @return
     */
    @Override
    public Integer update(ScRankSet scRankSet) throws Exception {
        ScRankSetExample example = new ScRankSetExample();
        example.createCriteria().andIdEqualTo(scRankSet.getId());
        List<ScRankSet> scRankSets = scRankSetMapper.selectByExample(example);
        if(scRankSets != null && scRankSets.size() > 0){
            ScRankSet scRankSet1 = scRankSets.get(0);
            FieldUtil.copyProperties(scRankSet1,scRankSet,ScRankSet.class);
            commonConfig.setMaxRank(scRankSet1.getMaxRank());
            return scRankSetMapper.updateByExample(scRankSet1, example);
        }
        return 0;
    }

    @Override
    public ScRankSet get() {
        ScRankSetExample example = new ScRankSetExample();
        List<ScRankSet> scRankSets = scRankSetMapper.selectByExample(example);
        if(scRankSets != null && scRankSets.size() > 0){
            return scRankSets.get(0);
        }
        return null;
    }
}
