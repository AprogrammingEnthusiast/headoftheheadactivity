package com.yiscn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HeadoftheheadactivityApplication.class);
    }

    /*public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class, args);
    }*/
}
