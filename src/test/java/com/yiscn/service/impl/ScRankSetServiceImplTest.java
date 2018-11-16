package com.yiscn.service.impl;

import com.yiscn.common.bean.CommonConfig;
import com.yiscn.entity.ScRankSet;
import com.yiscn.service.IScRankSetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScRankSetServiceImplTest {

    @Autowired
    private IScRankSetService scRankSetService;
    @Autowired
    private CommonConfig commonConfig;

    @Test
    public void update() throws Exception {

        System.out.println("========="+commonConfig.getMaxRank());

        ScRankSet scRankSet = new ScRankSet();
        scRankSet.setId(1);
        scRankSet.setMatchRuleName("最高200");
        scRankSet.setMaxRank(200);
        scRankSetService.update(scRankSet);

        System.out.println("========="+commonConfig.getMaxRank());

    }

    @Test
    public void getById() {

        System.out.println(commonConfig.getMaxRank());

    }
}