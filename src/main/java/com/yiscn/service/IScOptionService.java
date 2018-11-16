package com.yiscn.service;

import com.yiscn.entity.ScOption;
import com.yiscn.model.ScOptionDto;

import java.util.List;

/**
 *
 *    答案接口
 *
 * @author wangj
 * @date 2018/7/11 14:20
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScOptionService {

    List<ScOption> getOneBySubject(Integer subjectId);

    /**
     * 批量添加答案
     * @param scOptions
     * @return
     */
    Integer add(List<ScOption> scOptions);

    /**
     * 修改答案
     * @param scOption
     * @return
     * @throws Exception
     */
    Integer update(ScOption scOption) throws Exception;

    /**
     * 根据题目id删除答案
     * @param subjectId
     * @return
     */
    Integer removeBySubjectId(Integer subjectId);
}
