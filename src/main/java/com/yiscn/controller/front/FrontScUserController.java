package com.yiscn.controller.front;

import com.yiscn.common.bean.PageBean;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.entity.ScUser;
import com.yiscn.model.BackSubjectVo;
import com.yiscn.service.IScUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *    前台用户接口
 *
 * @author wangj
 * @date 2018/7/26 16:22
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "frontUser", tags = "frontUser", description = "前台用户接口")
@RestController
@RequestMapping("/front/user")
public class FrontScUserController {

    @Autowired
    private IScUserService scUserService;

    /**
     * 根据openId获取用户信息
     * @param
     * @return
     */
    @ApiOperation(value="根据openId获取用户信息", notes="根据openId获取用户信息")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/getByOpenId", method= RequestMethod.GET)
    public ResultWarp<ScUser> getByOpenId(@RequestParam(value = "openId") String openId){
        if(openId == null || "".equals(openId)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        ScUser scUser = scUserService.getByOpenId(openId);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,scUser);
    }

    /**
     * 根据用户id获取用户信息
     * @param
     * @return
     */
    @ApiOperation(value="根据用户id获取用户信息", notes="根据用户id获取用户信息")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/get", method= RequestMethod.GET)
    public ResultWarp<ScUser> get(@RequestParam(value = "id") Integer id){
        if(id == null || "".equals(id)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        ScUser scUser = scUserService.get(id);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,scUser);
    }
}
