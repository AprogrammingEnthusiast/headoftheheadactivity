package com.yiscn.service;

import com.yiscn.entity.ScSubjectType;
import com.yiscn.entity.ScTitleConfig;

import java.util.List;

/**
 *
 *    题目类型配置
 *
 * @author wangj
 * @date 2018/7/18 15:12
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScSubjectTypeService {

    List<ScSubjectType> getList();

    Integer BathUpdate(List<ScSubjectType> scSubjectTypes);

    Integer updateName(ScSubjectType scSubjectType);
}
