package com.yiscn.service;

import com.yiscn.entity.ScRankSet;

/**
 *
 * 排行设置接口
 *
 * @author wangj
 * @date 2018/7/18 9:47
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScRankSetService {

    Integer update(ScRankSet scRankSet) throws Exception;

    ScRankSet get();
}
