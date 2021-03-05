package com.huangyuan.websiteservice.test;

import com.huangyuan.orderservice.TestProviderOrderService;
import com.huangyuan.userservice.test.TestProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestProviderController {

    /**
     * mock 服务降级配置，必须和服务提供者实现相同的接口
     *
     * check = false 启动时不校验是否有对应service的提供者，避免互相依赖的服务提供者跑不起来
     */
    @Reference(check = false,mock = "com.huangyuan.websiteservice.test.mockservice.MockTestProviderService",cluster = "failfast")
    private TestProviderService testProviderService;

    @Reference(check = false,mock = "com.huangyuan.websiteservice.test.mockservice.MockTestProviderOrderService",cluster = "failfast")
    private TestProviderOrderService testProviderOrderService;

    @GetMapping("/userservice")
    public String testUserService(String command){
        return testProviderService.test(command);
    }

    @GetMapping("/orderservice")
    public String testOrderService(String command){
        return testProviderOrderService.test(command);
    }
}
