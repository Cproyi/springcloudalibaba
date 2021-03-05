package com.huangyuan.websiteservice.test.mockservice;

import com.huangyuan.orderservice.TestProviderOrderService;

public class MockTestProviderOrderService implements TestProviderOrderService {
    @Override
    public String test(String command) {
        return "服务器太忙了，请稍后再试";
    }
}
