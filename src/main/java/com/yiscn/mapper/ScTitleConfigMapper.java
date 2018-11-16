package com.yiscn.mapper;

import com.yiscn.entity.ScTitleConfig;
import com.yiscn.entity.ScTitleConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScTitleConfigMapper {
    long countByExample(ScTitleConfigExample example);

    int deleteByExample(ScTitleConfigExample example);

    int insert(ScTitleConfig record);

    int insertSelective(ScTitleConfig record);

    List<ScTitleConfig> selectByExample(ScTitleConfigExample example);

    int updateByExampleSelective(@Param("record") ScTitleConfig record, @Param("example") ScTitleConfigExample example);

    int updateByExample(@Param("record") ScTitleConfig record, @Param("example") ScTitleConfigExample example);
}