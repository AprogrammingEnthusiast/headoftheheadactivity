package com.yiscn.mapper;

import com.yiscn.entity.ScExperience;
import com.yiscn.entity.ScExperienceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScExperienceMapper {
    long countByExample(ScExperienceExample example);

    int deleteByExample(ScExperienceExample example);

    int insert(ScExperience record);

    int insertSelective(ScExperience record);

    List<ScExperience> selectByExample(ScExperienceExample example);

    int updateByExampleSelective(@Param("record") ScExperience record, @Param("example") ScExperienceExample example);

    int updateByExample(@Param("record") ScExperience record, @Param("example") ScExperienceExample example);
}