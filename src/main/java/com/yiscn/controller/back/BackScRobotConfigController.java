package com.yiscn.controller.back;

import com.yiscn.common.bean.PageBean;
import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.exception.NullFieldException;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.entity.ScRobotConfig;
import com.yiscn.model.BackSubjectVo;
import com.yiscn.model.ScSubjectDto;
import com.yiscn.service.IScRobotService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *    后台机器人配置
 *
 * @author wangj
 * @date 2018/7/25 20:11
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backRobotConfig", tags = "backRobotConfig", description = "后台机器人配置")
@RestController
@RequestMapping("/back/robotConfig")
public class BackScRobotConfigController {

    @Autowired
    private IScRobotService scRobotService;

    /**
     * 获取机器人列表
     * @param
     * @return
     */
    @ApiOperation(value="获取机器人列表", notes="根据所属区域和是否启用获取机器人类表")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isUse", value = "是否启用", dataType = "Boolean"),
            @ApiImplicitParam(name = "areaId", value = "所属排位区域id", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true, dataType = "Integer")
    })
    @RequestMapping(value="/getPageBean", method= RequestMethod.GET)
    public ResultWarp<PageBean<ScRobotConfig>> getPageBean(@RequestParam(value = "isUse",required = false) Boolean isUse,
                                                       @RequestParam(value = "areaId",required = false) Integer areaId,
                                                       @RequestParam(value = "pageNum") Integer pageNum,
                                                       @RequestParam(value = "pageSize") Integer pageSize){
        if(pageNum == null || pageNum.equals(0) || pageSize == null || pageSize.equals(0)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        PageBean<ScRobotConfig> pageBean = scRobotService.getPageBean(isUse, areaId, pageNum, pageSize);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,pageBean);
    }

    /**
     * 添加机器人
     * @param
     * @return
     */
    @ApiOperation(value="添加机器人", notes="添加机器人")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Result add(@RequestBody ScRobotConfig scRobotConfig) {
        try {
            FieldUtil.checkNullFiled(scRobotConfig,"id");
        } catch (IllegalAccessException | NullFieldException e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/robotConfig/add",e);
            return new Result(StatusCode.PARAMETER_EXCEPTION);
        }
        Integer add = scRobotService.add(scRobotConfig);
        if(add > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 修改机器人配置
     * @param
     * @return
     */
    @ApiOperation(value="修改机器人配置", notes="修改机器人配置")
    @ApiResponses(value = {
            @ApiResponse(code = 2, message = "操作失败,且异常被捕获"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public Result update(@RequestBody ScRobotConfig scRobotConfig){
        Integer update;
        try {
            FieldUtil.checkNullFiled(scRobotConfig);
            update = scRobotService.update(scRobotConfig);
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/robotConfig/update",e);
            return new Result(StatusCode.CATCH_EXCEPTION_CODE);
        }
        if(update > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 删除机器人
     * @param
     * @return
     */
    @ApiOperation(value="删除机器人", notes="删除机器人")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/remove", method= RequestMethod.DELETE)
    public Result remove(@RequestParam(value = "id") Integer id){
        if(id == null || id.equals(0)){
            return new Result(StatusCode.PARAMETER_EXCEPTION);
        }
        Integer remove = scRobotService.remove(id);
        if(remove > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }
}
