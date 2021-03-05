package com.huangyuan.websiteservice;

import com.huangyuan.userservice.test.TestProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@DubboComponentScan
public class WebsiteServiceApplication
{


    /**
     * 不使用注册中心，直接使用服务
     */
    /**
    @Reference(url = "dubbo://127.0.0.1:20880/com.huangyuan.userservice.test.TestProviderService")
    private TestProviderService testProviderService;
    */

    public static void main( String[] args )
    {
        SpringApplication.run(WebsiteServiceApplication.class,args);

    }

    /**
     * 在开发中可能会有这样的情景。需要在容器启动的时候执行一些内容。
     * 比如读取配置文件，数据库连接之类的。SpringBoot给我们提供了
     * 两个接口来帮助我们实现这种需求。这两个接口分别为CommandLineRunner
     * 和ApplicationRunner。他们的执行时机为容器启动完成的时候。
     * @return
     */
    /*&
    @Bean
    ApplicationRunner runner(){
        return args->System.out.print(testProviderService.test("website say hello"));
    }
    */
}
