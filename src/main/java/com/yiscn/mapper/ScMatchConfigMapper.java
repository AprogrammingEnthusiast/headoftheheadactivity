package com.yiscn.mapper;

import com.yiscn.entity.ScMatchConfig;
import com.yiscn.entity.ScMatchConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScMatchConfigMapper {
    long countByExample(ScMatchConfigExample example);

    int deleteByExample(ScMatchConfigExample example);

    int insert(ScMatchConfig record);

    int insertSelective(ScMatchConfig record);

    List<ScMatchConfig> selectByExample(ScMatchConfigExample example);

    int updateByExampleSelective(@Param("record") ScMatchConfig record, @Param("example") ScMatchConfigExample example);

    int updateByExample(@Param("record") ScMatchConfig record, @Param("example") ScMatchConfigExample example);
}