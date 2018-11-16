package com.yiscn;

import com.yiscn.socket.QualifyingSocket;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 *    启动类
 *
 * @author wangj
 * @date 2018/7/16 11:46
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@SpringBootApplication
//启用事物
@EnableTransactionManagement
@MapperScan("com.yiscn.mapper")
@ServletComponentScan
@EnableCaching
public class HeadoftheheadactivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeadoftheheadactivityApplication.class, args);
		//QualifyingSocket.setApplicationContext(run);
	}
}
