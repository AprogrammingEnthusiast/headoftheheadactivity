package com.yiscn.service.impl;

import com.yiscn.common.util.FieldUtil;
import com.yiscn.entity.ScOption;
import com.yiscn.entity.ScOptionExample;
import com.yiscn.mapper.ScOptionMapper;
import com.yiscn.mapper.add.ScOptionAddMapper;
import com.yiscn.service.IScOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *    答案接口
 *
 * @author wangj
 * @date 2018/7/11 14:22
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scOptionServiceImpl")
public class ScOptionServiceImpl implements IScOptionService {

    @Autowired(required = false)
    private ScOptionMapper scOptionMapper;
    @Autowired(required = false)
    private ScOptionAddMapper scOptionAddMapper;

    /**
     * 根据题目id查询所有答案
     * @param subjectId
     * @return
     */
    @Override
    public List<ScOption> getOneBySubject(Integer subjectId) {
        ScOptionExample example = new ScOptionExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId);
        return scOptionMapper.selectByExample(example);
    }

    @Override
    public Integer add(List<ScOption> scOptions) {
        return scOptionAddMapper.batchAdd(scOptions);
    }

    @Override
    public Integer update(ScOption scOption) throws Exception {
        ScOptionExample example = new ScOptionExample();
        example.createCriteria().andSubjectIdEqualTo(scOption.getId());
        final List<ScOption> scOptions = scOptionMapper.selectByExample(example);
        if(scOptions != null && scOptions.size() > 0){
            ScOption scOption1 = scOptions.get(0);
            FieldUtil.copyProperties(scOption,scOption1,ScOption.class);
            final int i = scOptionMapper.updateByExample(scOption, example);
            return i;
        }
        return 0;
    }

    @Override
    public Integer removeBySubjectId(Integer subjectId) {
        ScOptionExample example = new ScOptionExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId);
        return scOptionMapper.deleteByExample(example);
    }
}
