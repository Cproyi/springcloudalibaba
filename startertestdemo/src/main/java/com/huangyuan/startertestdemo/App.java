package com.huangyuan.startertestdemo;

import org.redisson.api.RedissonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class,args);

        RedissonClient redissonClient = applicationContext.getBean(RedissonClient.class);
        redissonClient.getSet("key");
        System.out.print(redissonClient);

    }
}
