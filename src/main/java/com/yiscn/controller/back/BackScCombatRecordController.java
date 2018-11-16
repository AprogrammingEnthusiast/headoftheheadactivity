package com.yiscn.controller.back;

import com.yiscn.common.bean.PageBean;
import com.yiscn.common.bean.ResultWarp;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.entity.ScCombatRecord;
import com.yiscn.model.ScUserExperienceVo;
import com.yiscn.service.IScCombatRecordService;
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
 *    后台用户对战记录接口
 *
 * @author wangj
 * @date 2018/7/26 17:35
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backCombatrecord", tags = "backCombatrecord", description = "后台用户对战记录接口")
@RestController
@RequestMapping("/back/combatrecord")
public class BackScCombatRecordController {

    @Autowired
    private IScCombatRecordService scCombatRecordService;

    /**
     * 根据条件查询每用户的对战信息
     * @param
     * @return
     */
    @ApiOperation(value="根据条件查询每用户的对战信息", notes="根据条件查询每用户的对战信息：result=1、胜利2、失败3、平局")
    @ApiResponses(value = {
            @ApiResponse(code = 3, message = "参数异常"),
            @ApiResponse(code = 1, message = "操作成功")})
    @RequestMapping(value="/getPageBean", method= RequestMethod.GET)
    public ResultWarp<PageBean<ScCombatRecord>> getPageBean(@RequestParam(value = "userId") Integer userId,
                                                                @RequestParam(value = "areaId",required = false) Integer areaId,
                                                                @RequestParam(value = "relust",required = false) Integer relust,
                                                                @RequestParam(value = "pageNum") Integer pageNum,
                                                                @RequestParam(value = "pageSize") Integer pageSize){
        if(userId == null || "".equals(userId)||pageNum == null || "".equals(pageNum) || pageSize == null || "".equals(pageSize)){
            return new ResultWarp<>(StatusCode.PARAMETER_EXCEPTION,null);
        }
        PageBean<ScCombatRecord> pageBean = scCombatRecordService.getPageBean(userId, areaId, relust, pageNum, pageSize);
        return new ResultWarp<>(StatusCode.SUCCESS_CODE,pageBean);
    }
}
