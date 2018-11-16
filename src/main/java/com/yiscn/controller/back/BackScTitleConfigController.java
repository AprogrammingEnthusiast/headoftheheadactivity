package com.yiscn.controller.back;

import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.entity.ScMatchConfig;
import com.yiscn.entity.ScTitleConfig;
import com.yiscn.service.IScTitleConfigService;
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
 *    后台称谓接口
 *
 * @author wangj
 * @date 2018/7/25 19:07
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backTitleConfig", tags = "backTitleConfig", description = "后台称谓接口")
@RestController
@RequestMapping("/back/titleConfig")
public class BackScTitleConfigController {

    @Autowired
    private IScTitleConfigService scTitleConfigService;

    /**
     * 修改称谓
     * @param
     * @return
     */
    @ApiOperation(value="修改称谓", notes="修改一个称谓")
    @ApiResponses(value = {
            @ApiResponse(code = 2, message = "操作失败,且异常被捕获"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public Result update(@RequestBody ScTitleConfig scTitleConfig){
        Integer update;
        try {
            FieldUtil.checkNullFiled(scTitleConfig);
            update = scTitleConfigService.update(scTitleConfig);
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/titleConfig/update",e);
            return new Result(StatusCode.CATCH_EXCEPTION_CODE);
        }
        if(update > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 获取全部称谓信息
     * @param
     * @return
     */
    @ApiOperation(value="获取全部称谓信息", notes="获取全部称谓信息用于后台展示列表")
    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public ResultWarp<List<ScTitleConfig>> get(){
        List<ScTitleConfig> list = scTitleConfigService.getList();
        if(list != null && list.size() > 0){
            return new ResultWarp<>(StatusCode.SUCCESS_CODE,list);
        }
        return new ResultWarp<>(StatusCode.FAIL_CODE,null);
    }
}
