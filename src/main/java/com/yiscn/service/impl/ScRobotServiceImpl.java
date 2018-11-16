package com.yiscn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiscn.common.bean.CommonConfig;
import com.yiscn.common.bean.PageBean;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.entity.ScRobotConfig;
import com.yiscn.entity.ScRobotConfigExample;
import com.yiscn.mapper.ScRobotConfigMapper;
import com.yiscn.service.IScRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 *    机器人配置接口
 *
 * @author wangj
 * @date 2018/7/23 17:17
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scRobotServiceImpl")
public class ScRobotServiceImpl implements IScRobotService {

    @Autowired(required = false)
    private ScRobotConfigMapper scRobotConfigMapper;
    @Autowired
    private CommonConfig commonConfig;
    /**
     * 机器人类型个数
     */
    private static final Integer ROBOT_TYPE_SIZE = 4;

    @Override
    public Map<Integer, Set<ScRobotConfig>> getConfig() {

        Map<Integer, Set<ScRobotConfig>> map = new HashMap<>(4);
        int num = 1;
        Set<ScRobotConfig> set;
        List<ScRobotConfig> listByType;
        for (;num <= ROBOT_TYPE_SIZE;num++) {
            listByType = getListByType(num);
            set = new HashSet<>(listByType);
            map.put(num,set);
        }
        return map;
    }

    @Override
    public ScRobotConfig getOne(Integer id) {
        ScRobotConfigExample example = new ScRobotConfigExample();
        example.createCriteria().andIdEqualTo(id);
        List<ScRobotConfig> scRobotConfigs = scRobotConfigMapper.selectByExample(example);
        if(scRobotConfigs != null && scRobotConfigs.size() > 0){
            return scRobotConfigs.get(0);
        }
        return null;
    }

    @Override
    public List<ScRobotConfig> getListByType(Integer robotType) {
        ScRobotConfigExample example = new ScRobotConfigExample();
        example.createCriteria().andRobotareaEqualTo(robotType).andRobotisuseEqualTo(true);
        return scRobotConfigMapper.selectByExample(example);
    }

    @Override
    public Integer add(ScRobotConfig scRobotConfig) {
        int insert = scRobotConfigMapper.insert(scRobotConfig);
        if(insert > 0){
            commonConfig.putRobotConfig();
            return insert;
        }
        return 0;
    }

    @Override
    public Integer update(ScRobotConfig scRobotConfig) throws Exception {
        Integer id = scRobotConfig.getId();

        if(id == null || id == 0){
            return 0;
        }
        ScRobotConfigExample example = new ScRobotConfigExample();
        example.createCriteria().andIdEqualTo(id);
        List<ScRobotConfig> scRobotConfigs = scRobotConfigMapper.selectByExample(example);
        if(scRobotConfigs != null && scRobotConfigs.size() > 0){
            ScRobotConfig scRobotConfig1 = scRobotConfigs.get(0);
            FieldUtil.copyProperties(scRobotConfig1,scRobotConfig,ScRobotConfig.class);
            int i = scRobotConfigMapper.updateByExample(scRobotConfig, example);
            if(i > 0){
                commonConfig.putRobotConfig();
                return i;
            }
            return 0;
        }
        return 0;
    }

    @Override
    public PageBean<ScRobotConfig> getPageBean(Boolean isUse, Integer areaId, Integer pageNum, Integer pageSize) {

        ScRobotConfigExample example = new ScRobotConfigExample();
        ScRobotConfigExample.Criteria criteria = example.createCriteria();
        if(isUse != null){
            criteria.andRobotisuseEqualTo(isUse);
        }
        if(areaId != null && !areaId.equals(0)){
            criteria.andRobotareaEqualTo(areaId);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ScRobotConfig> scRobotConfigs = scRobotConfigMapper.selectByExample(example);
        PageInfo<ScRobotConfig> pageInfo = new PageInfo<>(scRobotConfigs);
        return new PageBean<>(pageInfo);

    }

    @Override
    public Integer remove(Integer id) {
        ScRobotConfigExample example = new ScRobotConfigExample();
        example.createCriteria().andIdEqualTo(id);
        int i = scRobotConfigMapper.deleteByExample(example);
        if(i > 0){
            commonConfig.putRobotConfig();
            return i;
        }
        return 0;
    }

    @Override
    public ScRobotConfig randGetOne(Integer areaId) {
        final Set<ScRobotConfig> scRobotConfigs = commonConfig.getScRobotConfigs().get(areaId);
        Random random = new Random();
        int i = random.nextInt(scRobotConfigs.size());
        int num = 0;
        for (ScRobotConfig scRobotConfig : scRobotConfigs){
            if(num == i){
                return scRobotConfig;
            }
            num ++;
        }
        return null;
    }
}
