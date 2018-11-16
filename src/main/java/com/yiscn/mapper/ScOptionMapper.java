package com.yiscn.mapper;

import com.yiscn.entity.ScOption;
import com.yiscn.entity.ScOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScOptionMapper {
    long countByExample(ScOptionExample example);

    int deleteByExample(ScOptionExample example);

    int insert(ScOption record);

    int insertSelective(ScOption record);

    Integer batchAdd(List<ScOption> scOptions);

    List<ScOption> selectByExample(ScOptionExample example);

    int updateByExampleSelective(@Param("record") ScOption record, @Param("example") ScOptionExample example);

    int updateByExample(@Param("record") ScOption record, @Param("example") ScOptionExample example);

}