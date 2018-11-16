package com.yiscn.mapper;

import com.yiscn.entity.ScSubject;
import com.yiscn.entity.ScSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScSubjectMapper {
    long countByExample(ScSubjectExample example);

    int deleteByExample(ScSubjectExample example);

    int insert(ScSubject record);

    int insertSelective(ScSubject record);

    List<ScSubject> selectByExample(ScSubjectExample example);

    int updateByExampleSelective(@Param("record") ScSubject record, @Param("example") ScSubjectExample example);

    int updateByExample(@Param("record") ScSubject record, @Param("example") ScSubjectExample example);
}