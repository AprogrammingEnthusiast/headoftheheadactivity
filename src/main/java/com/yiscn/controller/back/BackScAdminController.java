package com.yiscn.controller.back;

import com.yiscn.common.bean.AdminConfig;
import com.yiscn.common.bean.Result;
import com.yiscn.common.bean.StatusCode;
import com.yiscn.common.exception.NullFieldException;
import com.yiscn.common.util.FieldUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.model.AdminDto;
import com.yiscn.model.ScSubjectDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *    后台管理员接口
 *
 * @author wangj
 * @date 2018/7/24 17:51
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Api(value = "backAdmin", tags = "backAdmin", description = "后台管理员接口")
@RestController
@RequestMapping("/back/admin")
public class BackScAdminController {

    @Autowired
    private AdminConfig adminConfig;

    /**
     * 根据管理员用户名和密码校验登录
     * @param
     * @return
     */
    @ApiOperation(value="根据管理员用户名和密码校验登录", notes="根据管理员用户名和密码校验登录")
    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "登录成功"),
            @ApiResponse(code = 0, message = "用户名或密码错误")})
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public Result login(@RequestBody AdminDto adminDto) {
        if(adminConfig.getUsername().equals(adminDto.getUsername()) && adminConfig.getPassword().equals(adminDto.getPassword())){
            return new Result(StatusCode.SUCCESS_CODE);
        }
        return new Result(StatusCode.FAIL_CODE);
    }

}
