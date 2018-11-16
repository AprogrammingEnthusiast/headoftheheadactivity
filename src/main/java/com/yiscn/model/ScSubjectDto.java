package com.yiscn.model;

import com.yiscn.entity.ScOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("题目输入类")
public class ScSubjectDto {

    @ApiModelProperty("题目id")
    private Integer id;

    @ApiModelProperty("题目")
    private String quiz;

    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("学科")
    private String school;

    @ApiModelProperty("创始人")
    private String contributor;

    @ApiModelProperty("正确答案 1:A 2:B 3:C 4:D")
    private Integer answer;

    @ApiModelProperty("排位区域id 1.新手起步 2.熟手锻炼 3.头脑达人 4.旷世奇才")
    private Integer grade;

    @ApiModelProperty("答案输入对象")
    private List<ScOption> scOptions;
}
