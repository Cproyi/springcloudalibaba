package com.huangyuan.userservice.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huangyuan.common.hyexception.HyException;
import com.huangyuan.userservice.modules.user.entity.TUser;
import com.huangyuan.userservice.modules.user.entity.TUserExt;
import com.huangyuan.userservice.modules.user.mapper.TUserMapper;
import com.huangyuan.userservice.modules.user.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-04
 */
@Service
@Component
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Override
    public IPage<TUser> listByPage(Page<TUser> page, TUser condition) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender",condition.getGender());
        return baseMapper.listByPage(page,queryWrapper);
    }

    @Override
    public IPage<TUserExt> listExtByPage(Page<TUserExt> page, TUserExt condition) {
        QueryWrapper<TUserExt> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender",condition.getGender());
        return baseMapper.listExtByPage(page,queryWrapper);
    }

    @Override
    public void insert(TUser user) {
        baseMapper.insert(user);
    }
}
