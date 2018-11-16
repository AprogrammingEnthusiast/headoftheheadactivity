package com.yiscn.controller.back;

import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.entity.ScMatchConfig;
import com.yiscn.entity.ScSubjectType;
import com.yiscn.model.ScSubjectDto;
import com.yiscn.service.IScMatchConfigService;
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
 *    后台排位区域配置接口
 *
 * @author wangj
 * @date 2018/7/24 20:12
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backMatchConfig", tags = "backMatchConfig", description = "后台排位区域配置接口")
@RestController
@RequestMapping("/back/matchConfig")
public class BackScMatchConfigController {

    @Autowired
    private IScMatchConfigService scMatchConfigService;

    /**
     * 修改排位区域设置
     * @param
     * @return
     */
    @ApiOperation(value="修改排位区域设置", notes="修改排位区域设置")
    @ApiResponses(value = {
            @ApiResponse(code = 2, message = "操作失败,且异常被捕获"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public Result update(@RequestBody ScMatchConfig scMatchConfig){
        Integer update;
        try {
            FieldUtil.checkNullFiled(scMatchConfig);
            update = scMatchConfigService.update(scMatchConfig);
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/matchConfig/update",e);
            return new Result(StatusCode.CATCH_EXCEPTION_CODE);
        }
        if(update > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 获取全部排位区域配置
     * @param
     * @return
     */
    @ApiOperation(value="获取全部排位区域配置", notes="获取全部排位区域配置")
    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public ResultWarp<List<ScMatchConfig>> get(){
        List<ScMatchConfig> list = scMatchConfigService.getList();
        if(list != null && list.size() > 0){
            return new ResultWarp<>(StatusCode.SUCCESS_CODE,list);
        }
        return new ResultWarp<>(StatusCode.FAIL_CODE,null);
    }
}
