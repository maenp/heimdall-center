package com.heimdall.center.console.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heimdall.center.console.dao.SysUserDao;
import com.heimdall.center.console.model.SysUser;
import com.heimdall.center.console.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserDao userMapper;

    // @Override 注解表明 addUser 方法是重写或实现了父类或接口中的 addUser 方法
    @Override
    public int addUser(SysUser user) {
        user.setCreateTime(LocalDateTime.now());
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(SysUser user) {
        return userMapper.updateById(user);
    }

    @Override
    public Page<SysUser> getUserList(Integer page, Integer pageSize) {
        Page<SysUser> p = new Page<SysUser>();
        p.setCurrent(page);
        p.setSize(pageSize);
        Page<SysUser> pageResult = userMapper.selectPage(p, null);
        return pageResult;
    }
}
