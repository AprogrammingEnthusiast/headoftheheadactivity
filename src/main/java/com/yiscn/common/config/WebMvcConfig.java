package com.yiscn.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yiscn.common.interceptor.CommonInterceptor;
import com.yiscn.common.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: DengLibin
 * @ Description:mvc的一些配置 包括配置拦截器,过滤器
 * @ DateTime:  19:24 2018/4/29 0029
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired(required = false)
    private LoginInterceptor loginInterceptor;
    @Autowired(required = false)
    private CommonInterceptor commonInterceptor;
    /**
     * 添加拦截器 设置拦截规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }

    /**
     * 添加参数解析器
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    /**
     * 修改json解析器(默认是Jackson)
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        //创建fastjson转换器实例
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //配置对象
        FastJsonConfig config = new FastJsonConfig();
        List<MediaType> mediaTypes = new ArrayList<>();
        //中文编码
        MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
        mediaTypes.add(mediaType);
        config.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue,
                SerializerFeature.DisableCircularReferenceDetect);
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }


}
