package com.yiscn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiscn.common.bean.PageBean;
import com.yiscn.common.bean.Result;
import com.yiscn.common.util.FieldUtil;
import org.springframework.util.Assert;
import com.yiscn.common.util.DateUtil;
import com.yiscn.entity.ScUser;
import com.yiscn.entity.ScUserExample;
import com.yiscn.mapper.ScUserMapper;
import com.yiscn.model.ScUserDto;
import com.yiscn.service.IScUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    用户接口
 *
 * @author wangj
 * @date 2018/7/9 18:48
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scUserServiceImpl")
public class ScUserServiceImpl implements IScUserService {

    @Autowired(required = false)
    private ScUserMapper scUserMapper;

    @Override
    public ScUser get(Integer id) {
        ScUserExample example = new ScUserExample();
        example.createCriteria().andIdEqualTo(id);
        final List<ScUser> scUsers = scUserMapper.selectByExample(example);
        if(scUsers != null && scUsers.size() > 0){
            return scUsers.get(0);
        }
        return null;
    }

    @Override
    public Integer add(ScUserDto scUserDto) {
        ScUser scUser = new ScUser();
        BeanUtils.copyProperties(scUserDto,scUser);
        scUser.setLevel(1);
        scUser.setParagraph(1);
        scUser.setCurtime(DateUtil.getNowDateString());
        scUser.setIntegral(0);
        scUser.setHeightvictory(0);
        scUser.setNowvictory(0);
        scUser.setAllfield(0);
        scUser.setWinfield(0);
        scUser.setWinrate("0");
        scUser.setExperience(0);
        return scUserMapper.insert(scUser);
    }

    @Override
    public Integer update(ScUser scUser) throws Exception {
        Integer userId = scUser.getId();

        if(userId == null || userId == 0){
            return 0;
        }

        ScUserExample example = new ScUserExample();
        example.createCriteria().andIdEqualTo(userId);
        final List<ScUser> scUsers = scUserMapper.selectByExample(example);
        if(scUsers != null && scUsers.size() > 0){
            ScUser scUser1 = scUsers.get(0);
            FieldUtil.copyProperties(scUser1,scUser,ScUser.class);
            return scUserMapper.updateByExample(scUser1,example);
        }
        return 0;
    }

    @Override
    public List<ScUser> getList() {
        ScUserExample example = new ScUserExample();
        example.createCriteria().andAllfieldNotEqualTo(0);
        example.setOrderByClause(" level DESC , experience DESC, allField DESC ");
        return scUserMapper.selectByExample(example);
    }

    @Override
    public PageBean<ScUser> getPageBean(String nickName, String openId, Integer level,
                                        Integer pageNum, Integer pageSize) {
        ScUserExample example = new ScUserExample();
        ScUserExample.Criteria criteria = example.createCriteria();
        if(nickName!=null && !"".equals(nickName)){
            criteria.andNicknameLike("%"+nickName+"%");
        }
        if(openId!=null && !"".equals(openId)){
            criteria.andOpenidEqualTo(openId);
        }
        if(level!=null && !"".equals(level)){
            criteria.andLevelEqualTo(level);
        }
        example.setOrderByClause(" level DESC , experience DESC, allField DESC ");
        PageHelper.startPage(pageNum,pageSize);
        List<ScUser> scUsers = scUserMapper.selectByExample(example);
        PageInfo<ScUser> pageInfo = new PageInfo<>(scUsers);
        return new PageBean<>(pageInfo);
    }

    @Override
    public Integer batchUpdateTo0(List<ScUser> scUsers) {
        ScUserExample example = new ScUserExample();
        AtomicInteger num = new AtomicInteger(0);
        scUsers.stream().forEach(e ->{
            example.createCriteria().andIdEqualTo(e.getId());
            e.setLevel(1);
            e.setParagraph(1);
            e.setIntegral(0);
            e.setHeightvictory(0);
            e.setNowvictory(0);
            e.setAllfield(0);
            e.setWinfield(0);
            e.setWinrate("0");
            scUserMapper.updateByExample(e,example);
            num.incrementAndGet();
        });
        return num.get();
    }

    @Override
    public ScUser getByOpenId(String openId) {
        ScUserExample example = new ScUserExample();
        example.createCriteria().andOpenidEqualTo(openId);
        List<ScUser> scUsers = scUserMapper.selectByExample(example);
        if(scUsers != null && scUsers.size() > 0){
            return scUsers.get(0);
        }
        return null;
    }
}
