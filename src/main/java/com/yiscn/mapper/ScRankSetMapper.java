package com.yiscn.mapper;

import com.yiscn.entity.ScRankSet;
import com.yiscn.entity.ScRankSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScRankSetMapper {
    long countByExample(ScRankSetExample example);

    int deleteByExample(ScRankSetExample example);

    int insert(ScRankSet record);

    int insertSelective(ScRankSet record);

    List<ScRankSet> selectByExample(ScRankSetExample example);

    int updateByExampleSelective(@Param("record") ScRankSet record, @Param("example") ScRankSetExample example);

    int updateByExample(@Param("record") ScRankSet record, @Param("example") ScRankSetExample example);
}