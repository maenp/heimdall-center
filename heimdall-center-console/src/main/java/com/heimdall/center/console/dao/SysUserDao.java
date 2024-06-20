package com.heimdall.center.console.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heimdall.center.console.model.SysUser;

public interface SysUserDao extends BaseMapper<SysUser>{
    SysUser getUserByUser(SysUser user);
}
