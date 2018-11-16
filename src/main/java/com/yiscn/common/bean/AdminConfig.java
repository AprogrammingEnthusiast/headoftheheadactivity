package com.yiscn.common.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 *    管理员账号配置
 *
 * @author wangj
 * @date 2018/7/24 17:49
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@Component
@ConfigurationProperties(prefix = "admin")
public class AdminConfig {

    private Integer username;

    private Integer password;

}
