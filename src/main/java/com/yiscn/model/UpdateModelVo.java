package com.yiscn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 *    修改模块开启出类
 *
 * @author wangj
 * @date 2018/7/30 12:36
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@AllArgsConstructor
@ApiModel("修改模块开启出类")
public class UpdateModelVo {

    @ApiModelProperty("模块id 1:排位赛:2:好友PK:3:学习小组")
    private Integer modelId;

    @ApiModelProperty("是否开启 true:开启、false:关闭")
    private Boolean isOpen;

}
