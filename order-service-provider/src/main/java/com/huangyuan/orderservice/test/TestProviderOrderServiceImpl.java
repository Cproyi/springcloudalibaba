package com.huangyuan.orderservice.test;

import com.huangyuan.orderservice.TestProviderOrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class TestProviderOrderServiceImpl implements TestProviderOrderService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String test(String command) {
        return String.format("%s received msg %s,reply back with hi",applicationName,command);
    }
}
