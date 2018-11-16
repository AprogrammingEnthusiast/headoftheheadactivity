package com.yiscn.convert;

import com.yiscn.entity.ScOption;
import com.yiscn.entity.ScSubject;
import com.yiscn.model.SubjectVo;

import java.util.List;

/**
 *
 *    把题目和答案封装成客户端可解析的题目对象
 *
 * @author wangj
 * @date 2018/7/11 14:27
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class SubjectAndOptionToSubjectVo {

    /**
     *
     * @param subject 题目
     * @param options 答案
     * @param num 番号
     * @return
     */
    public static SubjectVo convert(ScSubject subject, List<ScOption> options, Integer num){

        SubjectVo subjectVo = new SubjectVo();
        subjectVo.setNum(num);
        subjectVo.setId(subject.getId());
        subjectVo.setQuiz(subject.getQuiz());
        subjectVo.setType(subject.getType());
        subjectVo.setSchool(subject.getSchool());
        subjectVo.setContributor(subject.getContributor());
        subjectVo.setCurtime(subject.getCurtime());
        subjectVo.setAnswer(subject.getAnswer());
        subjectVo.setGrade(subject.getGrade());
        subjectVo.setOption(options);

        return subjectVo;
    }
}
