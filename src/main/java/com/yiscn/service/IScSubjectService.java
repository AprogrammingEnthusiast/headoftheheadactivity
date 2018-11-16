package com.yiscn.service;

import com.yiscn.common.bean.PageBean;
import com.yiscn.entity.ScSubject;
import com.yiscn.model.BackSubjectVo;
import com.yiscn.model.ScSubjectDto;
import com.yiscn.model.SubjectVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *    题目接口
 *
 * @author wangj
 * @date 2018/7/10 10:07
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IScSubjectService {

    /**
     * 随机发题
     * @param areaId
     * @return
     */
    List<SubjectVo> randomIusse(Integer areaId);

    /**
     * 后台添加题目
     * @param scSubjectDto
     * @return
     */
    Integer add(ScSubjectDto scSubjectDto);

    /**
     * 修改题目（修改jvm内存中的数据）
     * @param scSubjectDto
     * @return
     * @throws Exception
     */
    Integer update(ScSubjectDto scSubjectDto) throws Exception;

    /**
     * 获取全部题目集合
     * @return
     */
    Map<Integer,Set<ScSubject>> getIusse();

    /**
     * 删除题目（同时删除答案（修改jvm内存中的数据））
     * @param subjectId
     * @return
     */
    Integer remove(Integer subjectId);

    /**
     * 更具类型id和答题赛区id获取题目列表
     * @param subjectTypeId 题目类型id
     * @param areaId 赛区id
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageBean<BackSubjectVo> getList(Integer subjectTypeId, Integer areaId, Integer pageNum, Integer pageSize);
}
