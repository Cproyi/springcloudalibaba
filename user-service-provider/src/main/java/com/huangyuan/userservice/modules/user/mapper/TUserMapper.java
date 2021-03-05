package com.huangyuan.userservice.modules.user.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huangyuan.userservice.modules.user.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangyuan.userservice.modules.user.entity.TUserExt;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-04
 */
public interface TUserMapper extends BaseMapper<TUser> {

    IPage<TUser> listByPage(Page<TUser> page, @Param(Constants.WRAPPER)Wrapper<TUser> wrapper);

    IPage<TUserExt> listExtByPage(Page<TUserExt> page, @Param(Constants.WRAPPER)QueryWrapper<TUserExt> queryWrapper);
}
