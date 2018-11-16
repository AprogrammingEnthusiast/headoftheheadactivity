package com.yiscn.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: DengLibin
 * Date: 2018-05-25
 * Time: 10:23
 */
@Component
public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
           // httpServletResponse.setContentType("text/json;charset=utf-8"); //不能设置(否则ResponseBody返回对象转json出错)，SpringBoot已经设置了
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "false");
        //域名 生产环境不允许设置为“*”
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return true;
    }
}
