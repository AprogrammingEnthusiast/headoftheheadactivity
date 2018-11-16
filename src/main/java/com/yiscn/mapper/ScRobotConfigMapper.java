package com.yiscn.mapper;

import com.yiscn.entity.ScRobotConfig;
import com.yiscn.entity.ScRobotConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScRobotConfigMapper {
    long countByExample(ScRobotConfigExample example);

    int deleteByExample(ScRobotConfigExample example);

    int insert(ScRobotConfig record);

    int insertSelective(ScRobotConfig record);

    List<ScRobotConfig> selectByExample(ScRobotConfigExample example);

    int updateByExampleSelective(@Param("record") ScRobotConfig record, @Param("example") ScRobotConfigExample example);

    int updateByExample(@Param("record") ScRobotConfig record, @Param("example") ScRobotConfigExample example);
}