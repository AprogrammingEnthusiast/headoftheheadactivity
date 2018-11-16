package com.yiscn.mapper;

import com.yiscn.entity.ScCombatRecord;
import com.yiscn.entity.ScCombatRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScCombatRecordMapper {
    long countByExample(ScCombatRecordExample example);

    int deleteByExample(ScCombatRecordExample example);

    int insert(ScCombatRecord record);

    int insertSelective(ScCombatRecord record);

    List<ScCombatRecord> selectByExample(ScCombatRecordExample example);

    int updateByExampleSelective(@Param("record") ScCombatRecord record, @Param("example") ScCombatRecordExample example);

    int updateByExample(@Param("record") ScCombatRecord record, @Param("example") ScCombatRecordExample example);
}