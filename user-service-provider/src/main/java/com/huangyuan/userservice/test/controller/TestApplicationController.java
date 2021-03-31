package com.huangyuan.userservice.test.controller;

import com.huangyuan.common.web.HttpResult;
import com.huangyuan.userservice.test.service.TransactionAService;
import com.huangyuan.userservice.test.service.TransactionBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 整个应用功能测试
 */
@RestController
@RequestMapping("/test")
public class TestApplicationController {

    @Autowired
    private TransactionAService transactionAService;

    @Autowired
    private TransactionBService transactionBService;
    /**
     * 事务测试
     * 包括事务的隔离级别以及事务的传播机制的测试
     * @return
     */
    @GetMapping("/transactionTest")
    public HttpResult transactionTest(){
//        transactionAService.serviceA();
        transactionBService.serviceC();
        return HttpResult.success();
    }

}
