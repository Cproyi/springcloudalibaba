package com.huangyuan.userservice.modules.role.service.impl;

import com.huangyuan.userservice.modules.role.entity.TRole;
import com.huangyuan.userservice.modules.role.mapper.TRoleMapper;
import com.huangyuan.userservice.modules.role.service.TRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-31
 */
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements TRoleService {

    @Autowired
    private TRoleMapper roleMapper;

    @Override
    public void serviceA() {
        TRole tRole = new TRole();
        tRole.setCreateTime(LocalDateTime.now());
        tRole.setModifyTime(LocalDateTime.now());
        tRole.setName("roleA");

        roleMapper.insert(tRole);
    }
}
