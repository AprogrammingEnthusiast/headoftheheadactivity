package com.yiscn.controller.back;

import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.entity.ScRankSet;
import com.yiscn.service.IScRankSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *    后台排位排名设置
 *
 * @author wangj
 * @date 2018/7/27 9:59
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backRankSet", tags = "backRankSet", description = "后台排位排名设置")
@RestController
@RequestMapping("/back/rankSet")
public class BackScRankSetController {

    @Autowired
    private IScRankSetService scRankSetService;

    /**
     * 修改排位排名
     * @param
     * @return
     */
    @ApiOperation(value="修改排位排名", notes="修改排位排名")
    @ApiResponses(value = {
            @ApiResponse(code = 2, message = "操作失败,且异常被捕获"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public Result update(@RequestBody ScRankSet scRankSet){
        Integer update;
        try {
            FieldUtil.checkNullFiled(scRankSet);
            update = scRankSetService.update(scRankSet);
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/rankSet/update",e);
            return new Result(StatusCode.CATCH_EXCEPTION_CODE);
        }
        if(update > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 查询排位排名
     * @param
     * @return
     */
    @ApiOperation(value="查询排位排名", notes="查询排位排名")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public ResultWarp<ScRankSet> get(){
        ScRankSet scRankSet = scRankSetService.get();
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,scRankSet);
    }
}
