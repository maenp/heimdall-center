package com.heimdall.center.console.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heimdall.center.console.common.ErrorEnum;
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

    @PostMapping("/addUser")
    public JSONObject addUser(@RequestBody JSONObject requestJson) {
        try {
            CommonUtil.hasAllRequired(requestJson, "username", "password", "nickname");
            SysUser user = new SysUser();
            user.setUsername(requestJson.getString("username"));
            user.setPassword(requestJson.getString("password"));
            user.setNickname(requestJson.getString("nickname"));
            userService.addUser(user);
            return CommonUtil.successJson();
        } catch (RuntimeException e) {
            ErrorEnum errorEnum = ErrorEnum.E_0;
            errorEnum.setErrorMsg(e.getMessage());
            return CommonUtil.errorJson(errorEnum);
        }
    }

    @PostMapping("/updateUser")
    public JSONObject updateUser(@RequestBody JSONObject requestJson) {
        try {
            CommonUtil.hasAllRequired(requestJson, "userid");
            SysUser user = new SysUser();
            user.setUserId(requestJson.getInteger("userid"));
            String username = requestJson.getString("username");
            String password = requestJson.getString("password");
            String nickname = requestJson.getString("nickname");
            if (username != null) {
                user.setUsername(username);
            }
            if (password != null) {
                user.setPassword(password);
            }
            if (nickname != null) {
                user.setNickname(nickname);
            }
            userService.updateUser(user);
            return CommonUtil.successJson();
        } catch (RuntimeException e) {
            ErrorEnum errorEnum = ErrorEnum.E_0;
            errorEnum.setErrorMsg(e.getMessage());
            return CommonUtil.errorJson(errorEnum);
        }
    }

    @GetMapping("/getUserList")
    public JSONObject getUserList(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        try {
            Page<SysUser> pageResult = userService.getUserList(page, pageSize);
            return CommonUtil.successJson(pageResult);
        } catch (RuntimeException e) {
            ErrorEnum errorEnum = ErrorEnum.E_0;
            errorEnum.setErrorMsg(e.getMessage());
            return CommonUtil.errorJson(errorEnum);
        }
    }

    @PostMapping("/deleteUser")
    public JSONObject deleteUser(@RequestBody JSONObject requestJson) {
        try {
            CommonUtil.hasAllRequired(requestJson, "userid");
            userService.deleteUser(requestJson.getInteger("userid"));
            return CommonUtil.successJson();
        } catch (RuntimeException e) {
            ErrorEnum errorEnum = ErrorEnum.E_0;
            errorEnum.setErrorMsg(e.getMessage());
            return CommonUtil.errorJson(errorEnum);
        }
    }
}
