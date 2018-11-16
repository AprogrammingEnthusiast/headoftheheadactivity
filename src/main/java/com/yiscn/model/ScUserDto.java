package com.yiscn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 *    用户输入对象
 *
 * @author wangj
 * @date 2018/7/17 10:11
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@ApiModel("用户输入对象")
@Data
public class ScUserDto {

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

}
