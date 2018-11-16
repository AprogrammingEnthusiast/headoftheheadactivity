package com.yiscn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: 服务启动执行
 * User: DengLibin
 * Date: 2018-06-11
 * Time: 19:29
 */
/*@Component
@Order(value = 1) //执行顺序
public class StartRunner implements CommandLineRunner {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public void run(String... args) {
        redisTemplate.execute((RedisConnection con)->{
         con.flushDb(); //清除redis缓存
             return null;
        });
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }
}*/
