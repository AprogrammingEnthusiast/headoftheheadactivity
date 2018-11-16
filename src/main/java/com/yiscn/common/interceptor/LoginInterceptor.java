package com.yiscn.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ Author: DengLibin
 * @ Description: 登陆拦截器,在WebAppConfig中添加
 * @ DateTime:  19:12 2018/4/29 0029
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
             * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {

        //System.out.println("---------------------开始进入请求地址拦截----------------------------");
       // HttpSession session = httpServletRequest.getSession();
        if(false){
            httpServletResponse.setContentType("text/json;charset=utf-8");
            httpServletResponse.setCharacterEncoding("utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write("已被HelloInterceptor拦截");
            writer.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
       //System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("---------------视图渲染之后的操作-------------------------");
    }
}
