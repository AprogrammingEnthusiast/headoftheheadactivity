package com.yiscn.controller;

import com.yiscn.common.bean.CommonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author: DengLibin
 * @ Description:
 * @ DateTime:  16:16 2018/5/18 0018
 */
@RestController
@RequestMapping("/simple")
public class SampleController {

    @Autowired
    private CommonConfig commonConfig;

    @RequestMapping("/hello")
    public String hello() {
        return commonConfig.getMaxRank().toString();
    }
}
