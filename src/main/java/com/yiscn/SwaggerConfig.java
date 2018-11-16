
package com.yiscn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 *
 *    http://localhost/swagger-ui.html
 *
 * @author wangj
 * @date 2018/7/24 14:51
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */

@Configuration
@EnableSwagger2 //启用Swagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yiscn.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("竞技学院服务端Restful Api")
                .description("基于springBoot的整合开发")
                .termsOfServiceUrl("https://swagger.io/")
                .contact( new Contact("王键","http://wangj.top","1009057923@163.com"))
                .version("1.0")
                .build();
    }
}

