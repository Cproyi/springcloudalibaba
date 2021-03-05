package com.huangyuan.websiteservice.test.mockservice;

import com.huangyuan.userservice.test.TestProviderService;

/**
 * TestProviderService务降级调用接口
 */
public class MockTestProviderService implements TestProviderService {
    @Override
    public String test(String command) {
        return "服务器太忙了，请稍后再试";
    }
}
