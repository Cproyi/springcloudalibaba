package com.huangyuan.userservice.test.service;

import com.huangyuan.common.hyexception.HyException;
import com.huangyuan.userservice.modules.user.entity.TUser;
import com.huangyuan.userservice.modules.user.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 本测试用于验证事务的传播的语义
 *
 * 主结论：
 * 1.事务的传播必须要在不同的类中才能生效，因为同一个类中的相互调用并不会经过代理类的调用，故无法织入事务的逻辑
 * 2.springboot在不主动设置的情况下，是没有事务的
 */
@Service
public class TransactionAService {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TransactionBService transactionBService;

    /**
     * 以下注释'->'符号左侧表示调用方，右侧表示被调用方
     * 1.supports :A（有事务）->B(supports) //结果：B有异常，全部回滚，B无异常 全部提交成功
     * 2.supports :直接调用B（supports） B中有异常，//结果：报错，但是数据插入成功
     * 结论：supports表示当前有事务则加入事务，否则以非事务的方式执行 ， 由以上实验可知，supports是针对于被调用方来讲的，
     * 被supports修饰的服务在被调用时，如果调用者有事务，则加入调用方的事务，否则以非事务方式进行，
     * 从实验2可以看出来：@Transactional(propagation = Propagation.SUPPORTS)修饰的服务本身是没有事务的，只是会借用调用者的事务
     *
     *
     * 3.MANDATORY 单独调用B(MANDATORY) 无异常 //结果： 执行失败，报错No existing transaction found...
     * 4.MANDATORY A(无事务)->B(MANDATORY) //结果：A插入成功（因为没有事务的控制），B报错No existing transaction found...
     * 5.MANDATORY A(有事务)->B(MANDATORY) //结果：无运行时异常，全部插入成功，有运行时异常全部回滚

     * 结论：MANDATORY 针对于被调用方，调用方有事务则加入，无事务则报错
     *
     * 6.NEVER A(有事务)->B(NEVER) 均无异常  //报错，Existing transaction found，A插入不成功
     *
     * 大结论：不在继续测试，可以预想
     *
     * @throws HyException
     */
//    @Transactional
    public void serviceA() throws HyException {
        TUser tUser = new TUser();
        tUser.setGender("F");
        tUser.setCreateTime(LocalDateTime.now());
        tUser.setName("A");
        tUser.seteName("Jennie");
        tUser.setUpdateTime(LocalDateTime.now());
        tUserService.insert(tUser);

        transactionBService.serviceB();
//        float i = 1/0;
    }
}
