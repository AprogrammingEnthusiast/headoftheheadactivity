package com.yiscn.controller.back;

import com.yiscn.common.bean.PageBean;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.entity.ScExperience;
import com.yiscn.entity.ScUser;
import com.yiscn.model.ScUserExperienceVo;
import com.yiscn.service.IScExperienceservice;
import com.yiscn.service.IScUserService;
import io.swagger.annotations.*;
import org.apache.xpath.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 *
 *    后台用户接口
 *
 * @author wangj
 * @date 2018/7/26 16:22
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backUser", tags = "backUser", description = "后台用户接口")
@RestController
@RequestMapping("/back/user")
public class BackScUserController {

    @Autowired
    private IScUserService scUserService;
    @Autowired
    private IScExperienceservice scExperienceservice;

    /**
     * 根据月份查询历史用户排行
     * @param
     * @return
     */
    @ApiOperation(value="根据月份查询历史用户排行", notes="根据月份查询历史用户排行")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/getOldPageBean", method= RequestMethod.GET)
    public ResultWarp<PageBean<ScUserExperienceVo>> getPageBean(@RequestParam(value = "mouth") Integer mouth,
                                                                @RequestParam(value = "pageNum") Integer pageNum,
                                                                @RequestParam(value = "pageSize") Integer pageSize){
        if(mouth == null || "".equals(mouth)||pageNum == null || "".equals(pageNum) || pageSize == null || "".equals(pageSize)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        PageBean<ScUserExperienceVo> list = scExperienceservice.getPageBean(mouth, pageNum, pageSize);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,list);
    }

    /**
     * 多条件查询用户
     * @param
     * @return
     */
    @ApiOperation(value="查询当前用户", notes="按照等级，经验，总场次的顺序排序查询所有用户")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "昵称", dataType = "String"),
            @ApiImplicitParam(name = "openId", value = "openId", dataType = "String"),
            @ApiImplicitParam(name = "level", value = "等级", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true, dataType = "Integer")
    })
    @RequestMapping(value="/getPageBean", method= RequestMethod.GET)
    public ResultWarp<PageBean<ScUser>> getPageBean(@RequestParam(value = "nickName",required = false) String nickName,
                                                    @RequestParam(value = "openId",required = false) String openId,
                                                    @RequestParam(value = "level",required = false) Integer level,
                                                    @RequestParam(value = "pageNum") Integer pageNum,
                                                    @RequestParam(value = "pageSize") Integer pageSize){
        if(pageNum == null || "".equals(pageNum) || pageSize == null || "".equals(pageSize)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        PageBean<ScUser> pageBean = scUserService.getPageBean(nickName,openId,level,pageNum, pageSize);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,pageBean);
    }

    /**
     * 查询某用户历史排名
     * @param
     * @return
     */
    @ApiOperation(value="查询某用户历史排名", notes="查询某用户历史排名，不传月份择查询所有历史用户")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/getOneOld", method= RequestMethod.GET)
    public ResultWarp<List<ScExperience>> getOneOld(@RequestParam(value = "mouth" ,required = false) Integer mouth,
                                                    @RequestParam(value = "userId") Integer userId){
        if(userId == null || "".equals(userId)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        List<ScExperience> one = scExperienceservice.getOne(mouth, userId);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,one);
    }

    /**
     * 历史排名导出
     * @param
     * @return
     */
    @ApiOperation(value="历史排名导出", notes="根据月份查询历史用户排行")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/getPassDreamexport", method= RequestMethod.POST)
    public ResultWarp<String> getPassDreamexport(@RequestParam(value = "mouth") Integer mouth,
                                                 @RequestParam(value = "size") Integer size){
        if(mouth == null || "".equals(mouth) || size == null || "".equals(size)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        String path = BackScUserController.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        String passDreamexport = scExperienceservice.getPassDreamexport(mouth, size, path+ File.separator+"public");
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,passDreamexport);
    }
}
