package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liangtong.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        //登录
        User loginUser = userService.login(user.getUsername(),user.getPassword());
        //将用户信息直接返回 , 如果不是空登录成功，如果是空失败
        return ResponseEntity.ok(loginUser);
    }



}
