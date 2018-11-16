package com.yiscn.model;

import com.yiscn.entity.ScOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 *
 *    随机题目传至客户端对象
 *
 * @author wangj
 * @date 2018/7/10 10:26
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectVo {

    private Integer num;

    private Integer id;

    private String quiz;

    private Integer type;

    private String school;

    private String contributor;

    private String curtime;

    private Integer answer;

    private Integer grade;

    private List<ScOption> option;

}
