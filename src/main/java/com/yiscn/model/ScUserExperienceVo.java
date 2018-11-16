package com.yiscn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("用户历史经验输出类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScUserExperienceVo {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("性别")
    private Boolean gender;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("头像")
    private String head;

    @ApiModelProperty("openId")
    private String openid;

    @ApiModelProperty("月份")
    private Integer mouth;

    @ApiModelProperty("等级")
    private Integer level;

    @ApiModelProperty("段位")
    private Integer paragraph;

    @ApiModelProperty("历史最高连胜")
    private Integer heightVictory;

    @ApiModelProperty("当前连胜")
    private Integer nowVictory;

    @ApiModelProperty("总场次")
    private Integer allField;

    @ApiModelProperty("胜场")
    private Integer winField;

    @ApiModelProperty("胜率")
    private String winRate;

    @ApiModelProperty("经验")
    private Integer experience;

    @ApiModelProperty("排名")
    private Integer rank;
}
