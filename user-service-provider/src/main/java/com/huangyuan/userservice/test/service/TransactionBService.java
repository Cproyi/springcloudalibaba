package com.huangyuan.userservice.test.service;

import com.huangyuan.common.hyexception.HyException;
import com.huangyuan.userservice.modules.role.service.TRoleService;
import com.huangyuan.userservice.modules.user.entity.TUser;
import com.huangyuan.userservice.modules.user.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionBService {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TRoleService tRoleService;

    /**
     * 实验B
     * 验证springboot是否有自动配置事务：
     * 无Transactional修饰，方法有运行时异常。看是否回滚
     * 现象及结论：未回滚，springboot的事务需要手动配置
     * @throws HyException
     */
//    @Transactional
    @Transactional(propagation = Propagation.MANDATORY)
    public void serviceB() throws HyException {
        TUser tUser = new TUser();
        tUser.setGender("F");
        tUser.setCreateTime(LocalDateTime.now());
        tUser.setName("B");
        tUser.seteName("Rose");
        tUser.setUpdateTime(LocalDateTime.now());
        tUserService.insert(tUser);
//        float i = 1/0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void serviceC() {
        TUser tUser = new TUser();
        tUser.setGender("F");
        tUser.setCreateTime(LocalDateTime.now());
        tUser.setName("C");
        tUser.seteName("Cose");
        tUser.setUpdateTime(LocalDateTime.now());
        tUserService.insert(tUser);
        serviceD();
        serviceE();
        float i = 1/0;

    }

//    @Transactional(rollbackFor = Exception.class)
    public void serviceD(){
        TUser tUser = new TUser();
        tUser.setGender("F");
        tUser.setCreateTime(LocalDateTime.now());
        tUser.setName("D");
        tUser.seteName("Dose");
        tUser.setUpdateTime(LocalDateTime.now());
        tUserService.insert(tUser);
    }

    private void serviceE(){
        tRoleService.serviceA();;
    }

}
