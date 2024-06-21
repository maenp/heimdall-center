package com.heimdall.center.console.service;

import com.heimdall.center.console.model.SysUser;

public interface UserService {


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
   int addUser(SysUser user);
}
