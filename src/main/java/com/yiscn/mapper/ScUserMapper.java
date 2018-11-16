package com.yiscn.mapper;

import com.yiscn.entity.ScUser;
import com.yiscn.entity.ScUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScUserMapper {
    long countByExample(ScUserExample example);

    int deleteByExample(ScUserExample example);

    int insert(ScUser record);

    int insertSelective(ScUser record);

    List<ScUser> selectByExample(ScUserExample example);

    int updateByExampleSelective(@Param("record") ScUser record, @Param("example") ScUserExample example);

    int updateByExample(@Param("record") ScUser record, @Param("example") ScUserExample example);
}