package com.heimdall.center.console.controller;


import com.alibaba.fastjson.JSONObject;
import com.heimdall.center.console.model.SysUser;
import com.heimdall.center.console.service.UserService;
import com.heimdall.center.console.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public JSONObject addUser() {
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setPassword("123456");
        user.setNickname("test-test");
        userService.addUser(user);
        return CommonUtil.successJson();
    }
}
