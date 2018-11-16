package com.yiscn.controller.back;

import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.exception.NullFieldException;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.model.UpdateModelDto;
import com.yiscn.model.UpdateModelVo;
import com.yiscn.service.IScCommonConfigService;
import com.yiscn.service.impl.ScCommonConfigServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *    修改非数据库配置接口
 *
 * @author wangj
 * @date 2018/7/30 12:33
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backCommonfig", tags = "backCommonfig", description = "修改非数据库配置接口")
@RestController
@RequestMapping("/back/commonfig")
public class BackScCommonfigController {

    @Autowired
    private IScCommonConfigService scCommonConfigService;

    /**
     * 开启或停止游戏模块
     * @param
     * @return
     */
    @ApiOperation(value="开启或停止游戏模块", notes="开启或停止游戏模块")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/updateModel", method= RequestMethod.PUT)
    public Result updateModel(@RequestBody List<UpdateModelDto> updateModelDtos) {
        try {
            FieldUtil.checkNullFiled(updateModelDtos);
        } catch (IllegalAccessException | NullFieldException e) {
            e.printStackTrace();
            SpringBootLogger.error("======//back/commonfig/updateModel",e);
            return new Result(StatusCode.PARAMETER_EXCEPTION);
        }
        Integer i = scCommonConfigService.bathUpdateModel(updateModelDtos);
        if(i > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 获取模块开启配置列表
     * @param
     * @return
     */
    @ApiOperation(value="获取模块开启配置列表", notes="获取模块开启配置列表")
    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public ResultWarp<List<UpdateModelVo>> get() {
        List<UpdateModelVo> list = scCommonConfigService.getList();
        if(list != null && list.size() > 0){
            return new ResultWarp<>(StatusCode.SUCCESS_CODE,list);
        }
        return new ResultWarp<>(StatusCode.FAIL_CODE,null);
    }
}
