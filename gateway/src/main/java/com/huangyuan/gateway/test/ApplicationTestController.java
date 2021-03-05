package com.huangyuan.gateway.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/gateway")
public class ApplicationTestController {

    @Value("${spring.cloud.zookeeper.connect-string}")
//    @Value("${spring.application.name}")
    private String value;

    @RequestMapping("/getValue")
    public String getValue(){
        return value;
    }
}
