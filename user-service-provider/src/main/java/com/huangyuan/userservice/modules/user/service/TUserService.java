package com.huangyuan.userservice.modules.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huangyuan.userservice.modules.user.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huangyuan.userservice.modules.user.entity.TUserExt;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-04
 */
public interface TUserService extends IService<TUser> {

    IPage<TUser> listByPage(Page<TUser> page, TUser condition);

    IPage<TUserExt> listExtByPage(Page<TUserExt> page, TUserExt condition);
}
