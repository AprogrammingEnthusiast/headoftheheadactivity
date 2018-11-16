package com.yiscn.weixin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author: DengLibin
 * @ Description: 微信业务 自动装配
 * @ DateTime:  10:33 2018/5/22 0022
 */
@Configuration
@ConditionalOnClass(WeiXinService.class)
@EnableConfigurationProperties(WeiXinProperties.class)
@ConditionalOnProperty(prefix = "weixin",value = "enabled",matchIfMissing = true)
public class WeiXinServiceAutoConfiguration {
    private WeiXinProperties weiXinProperties;
    public WeiXinServiceAutoConfiguration(WeiXinProperties weiXinProperties){
        this.weiXinProperties = weiXinProperties;
    }
    @Bean
    public IWeiXinService weiXinService(){
        IWeiXinService weiXinService = new WeiXinService(weiXinProperties.getAppId(),weiXinProperties.getAppSecret());
        return weiXinService;
    }

}
