package com.yiscn.mapper;

import com.yiscn.entity.ScSubjectType;
import com.yiscn.entity.ScSubjectTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScSubjectTypeMapper {
    long countByExample(ScSubjectTypeExample example);

    int deleteByExample(ScSubjectTypeExample example);

    int insert(ScSubjectType record);

    int insertSelective(ScSubjectType record);

    List<ScSubjectType> selectByExample(ScSubjectTypeExample example);

    int updateByExampleSelective(@Param("record") ScSubjectType record, @Param("example") ScSubjectTypeExample example);

    int updateByExample(@Param("record") ScSubjectType record, @Param("example") ScSubjectTypeExample example);
}