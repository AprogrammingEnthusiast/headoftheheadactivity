package com.yiscn.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiscn.common.bean.CommonConfig;
import com.yiscn.common.bean.PageBean;
import com.yiscn.common.util.DateUtil;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.convert.SubjectAndOptionToSubjectVo;
import com.yiscn.entity.ScOption;
import com.yiscn.entity.ScOptionExample;
import com.yiscn.entity.ScSubject;
import com.yiscn.entity.ScSubjectExample;
import com.yiscn.mapper.ScSubjectMapper;
import com.yiscn.model.BackSubjectVo;
import com.yiscn.model.ScSubjectDto;
import com.yiscn.model.SubjectVo;
import com.yiscn.service.IScOptionService;
import com.yiscn.service.IScSubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 *    题目
 *
 * @author wangj
 * @date 2018/7/10 10:09
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service("scSubjectServiceImpl")
public class ScSubjectServiceImpl implements IScSubjectService {

    private final static Integer RANDOM_SUBJECT_NUM = 5;

    @Autowired
    private IScOptionService scOptionService;
    @Autowired(required = false)
    private ScSubjectMapper scSubjectMapper;
    @Autowired
    private CommonConfig commonConfig;

    /**
     * 随机发题
     * @param areaId 选择大区
     * @return
     */
    @Override
    public List<SubjectVo> randomIusse(Integer areaId) {
        final Map<Integer, Set<ScSubject>> scSubjects = commonConfig.getScSubjects();
        List<SubjectVo> subjectVos = new ArrayList<>(RANDOM_SUBJECT_NUM);
        List<ScSubject> scSubjectList = new ArrayList<>(5);
        Integer size ;
        Random rand ;
        for (Map.Entry<Integer, Set<ScSubject>> entry : scSubjects.entrySet()) {
            Iterator<ScSubject> it = entry.getValue().iterator();
            //在对应题目类型的set中取第一道题
            size = entry.getValue().size();
            rand = new Random();
            int i = rand.nextInt(size) + 1;
            int num = 1;
            while (it.hasNext()) {
                if(num == i) {
                    scSubjectList.add(it.next());
                    break;
                }
                num ++;
            }
        }
        // 随机排序
        Collections.shuffle(scSubjectList);
        AtomicInteger num = new AtomicInteger(1);
        //对答题进行封装
        subjectVos = scSubjectList.stream().map(e ->{
            List<ScOption> scOptions = scOptionService.getOneBySubject(e.getId());
            SubjectVo subjectVo = SubjectAndOptionToSubjectVo.convert(e, scOptions, num.get());
            num.getAndIncrement();
            return subjectVo;
        }).collect(Collectors.toList());

        return subjectVos;
    }

    /**
     * 后台添加题目
     * @param scSubjectDto
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    public Integer add(ScSubjectDto scSubjectDto) {
        ScSubject scSubject = new ScSubject();
        BeanUtils.copyProperties(scSubjectDto,scSubject);
        scSubject.setCurtime(DateUtil.getNowDateString());
        if (scSubjectMapper.insert(scSubject)==1){
            final List<ScOption> scOptions1 = scSubjectDto.getScOptions();

            Integer subjectId = scSubject.getId();

            List<ScOption> scOptions = scOptions1.stream().map(e -> {
                e.setSubjectId(subjectId);
                return e;
            }).collect(Collectors.toList());

            final Integer add = scOptionService.add(scOptions);
            if(add > 0){
                //向配置内存中添加此题目
                commonConfig.getScSubjects().get(scSubject.getGrade()).add(scSubject);
                return 1;
            }
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    public Integer update(ScSubjectDto scSubjectDto) throws Exception {
        Integer subjectId = scSubjectDto.getId();
        ScSubject scSubject = new ScSubject();
        BeanUtils.copyProperties(scSubjectDto,scSubject);
        ScSubjectExample example = new ScSubjectExample();
        example.createCriteria().andIdEqualTo(subjectId);
        final List<ScSubject> scSubjects = scSubjectMapper.selectByExample(example);
        if(scSubjects != null && scSubjects.size() >0){
            final ScSubject scSubject1 = scSubjects.get(0);
            FieldUtil.copyProperties(scSubject1,scSubject,ScSubject.class);
            final int i = scSubjectMapper.updateByExample(scSubject1, example);
            if(i > 0){
                List<ScOption> scOptions = scSubjectDto.getScOptions();
                if(scOptions != null && scOptions.size() > 0){
                    int num = 0;
                    for (ScOption scOption:scOptions) {
                        scOptionService.update(scOption);
                        num ++;
                    }
                    if(num == scOptions.size()){
                        commonConfig.putSubject();
                        return 1;
                    }
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
                commonConfig.putSubject();
                return 1;
            }
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 0;
    }

    @Override
    public Map<Integer, Set<ScSubject>> getIusse() {
        Integer num = 1;
        Map<Integer, Set<ScSubject>> resultMap = new HashMap<>(5);
        Set set;
        for (;num <= RANDOM_SUBJECT_NUM;num ++){
            ScSubjectExample example = new ScSubjectExample();
            example.createCriteria().andTypeEqualTo(num);
            List<ScSubject> scSubjects = scSubjectMapper.selectByExample(example);
            set = new HashSet(scSubjects);
            resultMap.put(num,set);
        }
        return resultMap;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    public Integer remove(Integer subjectId) {
        final Integer integer = scOptionService.removeBySubjectId(subjectId);
        if(integer <= 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        ScSubjectExample example = new ScSubjectExample();
        example.createCriteria().andIdEqualTo(subjectId);
        int i = scSubjectMapper.deleteByExample(example);
        if(i > 0){
            commonConfig.putSubject();
            return i;
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }

    @Override
    public PageBean<BackSubjectVo> getList(Integer subjectTypeId, Integer areaId, Integer pageNum, Integer pageSize) {
        ScSubjectExample example = new ScSubjectExample();
        ScSubjectExample.Criteria criteria =  example.createCriteria();
        if(subjectTypeId != null && subjectTypeId != 0){
            criteria.andTypeEqualTo(subjectTypeId);
        }
        if(areaId != null && areaId != 0){
            criteria.andGradeEqualTo(areaId);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ScSubject> scSubjectList = scSubjectMapper.selectByExample(example);

        List<BackSubjectVo> list = scSubjectList.stream().map(e ->{
            BackSubjectVo subjectVo = new BackSubjectVo();
            BeanUtils.copyProperties(e,subjectVo);
            subjectVo.setScOptions(scOptionService.getOneBySubject(e.getId()));
            return subjectVo;
        }).collect(Collectors.toList());

        Page page = (Page) scSubjectList;

        PageInfo<BackSubjectVo> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(page.getTotal());
        return new PageBean<>(pageInfo);
    }
}
