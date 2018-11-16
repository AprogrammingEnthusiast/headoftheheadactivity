package com.yiscn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *    答案输入对象
 *
 * @author wangj
 * @date 2018/7/18 8:55
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@ApiModel("答案输入对象，由于配合题目输入对象一并传入，及没有题目id由逻辑生成")
public class ScOptionDto {

    @ApiModelProperty("答案id")
    private Integer id;

    @ApiModelProperty("选项编号 1:A 2:B 3:C 4:D")
    private Integer optionNum;

    @ApiModelProperty("答案")
    private String answer;

}
