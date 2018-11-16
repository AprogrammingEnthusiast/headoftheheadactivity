package com.yiscn.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**  
 *
 *    springboot websocket配置
 *   
 * @author wangj  
 * @date 2018/7/6 14:08
 * @param   
 * @return   
 * Life is so short,do something to make yourself happy,such as coding
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
