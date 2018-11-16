package com.yiscn.service.impl;

import com.yiscn.common.bean.CommonConfig;
import com.yiscn.model.UpdateModelDto;
import com.yiscn.model.UpdateModelVo;
import com.yiscn.service.IScCommonConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    修改非数据库配置接口
 *
 * @author wangj
 * @date 2018/7/30 9:59
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service
public class ScCommonConfigServiceImpl implements IScCommonConfigService {

    @Autowired
    private CommonConfig commonConfig;

    @Override
    public Integer updateModel(UpdateModelDto updateModelDto) {
        Integer result = 0;
        switch (updateModelDto.getModelId()){
            case 1: commonConfig.setMatchingPVP(updateModelDto.getIsOpen()); result = 1; break;
            case 2: commonConfig.setFiendPVP(updateModelDto.getIsOpen()); result = 1;  break;
            case 3: commonConfig.setLearnPVP(updateModelDto.getIsOpen()); result = 1;  break;
            default:break;
        }
        return result;
    }

    @Override
    public List<UpdateModelVo> getList() {
        List<UpdateModelVo> modelList = new ArrayList<>(3);
        modelList.add(new UpdateModelVo(1,commonConfig.getMatchingPVP()));
        modelList.add(new UpdateModelVo(2,commonConfig.getFiendPVP()));
        modelList.add(new UpdateModelVo(3,commonConfig.getLearnPVP()));
        return modelList;
    }

    @Override
    public Integer bathUpdateModel(List<UpdateModelDto> updateModelDtos) {
        AtomicInteger reslut = new AtomicInteger(0);
        updateModelDtos.stream().forEach( e ->
                reslut.getAndAdd(updateModel(e))
        );
        return reslut.get();
    }
}
