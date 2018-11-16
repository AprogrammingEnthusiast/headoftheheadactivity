package com.yiscn.weixin;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ Author: DengLibin
 * @ Description: 加载配置文件的微信相关信息
 * @ DateTime:  10:29 2018/5/22 0022
 */
@ConfigurationProperties("weixin")
public class WeiXinProperties {
    private String appId;
    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
