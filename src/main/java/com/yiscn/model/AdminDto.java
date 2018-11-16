package com.yiscn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("管理员登录对象")
public class AdminDto {

    @ApiModelProperty("用户名")
    private Integer username;

    @ApiModelProperty("密码")
    private Integer password;
}
