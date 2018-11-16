package com.yiscn.controller.back;

import com.yiscn.common.bean.PageBean;
import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.exception.NullFieldException;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.model.BackSubjectVo;
import com.yiscn.model.ScSubjectDto;
import com.yiscn.service.IScSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *    后台题目接口
 *
 * @author wangj
 * @date 2018/7/24 14:25
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backSubject", tags = "backSubject", description = "后台题目接口")
@RestController
@RequestMapping("/back/subject")
public class BackScSubjectController {

    @Autowired
    private IScSubjectService scSubjectService;

    /**
     * 添加题目
     * @param
     * @return
     */
    @ApiOperation(value="添加题目", notes="添加题目")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Result add(@RequestBody ScSubjectDto scSubjectDto) {
        try {
            FieldUtil.checkNullFiled(scSubjectDto,"id");
        } catch (IllegalAccessException | NullFieldException e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/subject/add",e);
            return new Result(StatusCode.PARAMETER_EXCEPTION);
        }
        Integer add = scSubjectService.add(scSubjectDto);
        if(add > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 修改题目
     * @param
     * @return
     */
    @ApiOperation(value="修改题目", notes="修改题目")
    @ApiResponses(value = {
            @ApiResponse(code = 2, message = "操作失败,且异常被捕获"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public Result update(@RequestBody ScSubjectDto scSubjectDto){
        Integer update;
        try {
            FieldUtil.checkNullFiled(scSubjectDto);
            update = scSubjectService.update(scSubjectDto);
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error("======/backe/subject/update",e);
            return new Result(StatusCode.CATCH_EXCEPTION_CODE);
        }
        if(update > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 删除题目
     * @param
     * @return
     */
    @ApiOperation(value="删除题目", notes="删除题目")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 0, message = "操作失败")})
    @RequestMapping(value="/remove", method= RequestMethod.DELETE)
    public Result remove(@RequestParam(value = "subjectId") Integer subjectId){
        if(subjectId == null || subjectId.equals(0)){
            return new Result(StatusCode.PARAMETER_EXCEPTION);
        }
        Integer remove = scSubjectService.remove(subjectId);
        if(remove > 0){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

    /**
     * 更具类型id和答题赛区id获取题目列表
     * @param
     * @return
     */
    @ApiOperation(value="更具类型id获取题目列表", notes="更具类型id获取题目列表")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/getList", method= RequestMethod.GET)
    public ResultWarp<PageBean<BackSubjectVo>> getList(@RequestParam(value = "subjectTypeId",required = false) Integer subjectTypeId,
                                                       @RequestParam(value = "areaId",required = false) Integer areaId,
                                                       @RequestParam(value = "pageNum") Integer pageNum,
                                                       @RequestParam(value = "pageSize") Integer pageSize){
        if(pageNum == null || "".equals(pageNum) || pageSize == null || "".equals(pageSize)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        PageBean<BackSubjectVo> list = scSubjectService.getList(subjectTypeId, areaId, pageNum,pageSize);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,list);
    }
}
