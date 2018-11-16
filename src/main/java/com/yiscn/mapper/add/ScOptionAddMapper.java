package com.yiscn.mapper.add;

import com.yiscn.entity.ScOption;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 *
 *
 *
 * @author wangj
 * @date 2018/7/26 12:06
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface ScOptionAddMapper {

    @Insert("<script>INSERT INTO sc_option ( " +
            "id, subject_id, option_num, answer " +
            ") VALUES " +
            "<foreach separator=\",\" index=\"index\" item=\"item\" collection=\"list\"> " +
            "( " +
            "#{item.id,jdbcType=INTEGER}, " +
            "#{item.subjectId,jdbcType=INTEGER}, " +
            "#{item.optionNum,jdbcType=INTEGER}, " +
            "#{item.answer,jdbcType=VARCHAR} " +
            ") " +
            "</foreach></script> ")
    Integer batchAdd(List<ScOption> scOptions);

}
