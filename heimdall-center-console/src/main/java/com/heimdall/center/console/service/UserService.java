package com.heimdall.center.console.service;

import com.heimdall.center.console.model.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
public interface UserService {


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
   int addUser(SysUser user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateUser(SysUser user);

    /**
     * 获取用户列表
     *
     * @param jsonObject
     * @return
     */
    Page<SysUser> getUserList(Integer page, Integer pageSize);

    /**
     * 删除用户
     * @param id
     * @return
     * 
    */
    int deleteUser(Integer id);

}
