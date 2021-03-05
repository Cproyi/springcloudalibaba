package com.huangyuan.userservice.modules.user.controller;


import com.alibaba.nacos.client.naming.net.HttpClient;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huangyuan.common.web.HttpResult;
import com.huangyuan.userservice.modules.user.entity.TUser;
import com.huangyuan.userservice.modules.user.entity.TUserExt;
import com.huangyuan.userservice.modules.user.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/user")
public class TUserController {

    @Autowired
    private TUserService userService;

    @RequestMapping("/get")
    public HttpResult get(Integer id){
        return HttpResult.success(userService.getById(id));
    }

    @RequestMapping("/listByPage")
    public HttpResult listByPage(String gender){
        Page<TUser> page = new Page<>(1,5);
        TUser condition = new TUser();
        condition.setGender(gender);

        return HttpResult.success(userService.listByPage(page,condition));
    }

    @RequestMapping("/listExtByPage")
    public HttpResult listExtByPage(String gender){
        Page<TUserExt> page = new Page<>(1,5);
        TUserExt condition = new TUserExt();
        condition.setGender(gender);

        return HttpResult.success(userService.listExtByPage(page,condition));
    }
}
