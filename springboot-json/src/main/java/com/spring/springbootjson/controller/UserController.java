package com.spring.springbootjson.controller;

import com.spring.springbootjson.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author:zdd
 * @Date： 2022/10/18 11:25
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setName("heh");
        user.setBirth(LocalDateTime.now());
        return user;
    }
}
