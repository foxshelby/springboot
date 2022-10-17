package com.springboot.springdataredis.controller;

import com.springboot.springdataredis.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/10/17 9:22
 */
@RestController
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String test(){
        User user = new User();
        user.setUsername("heo");
        user.setPassword("123");
        redisTemplate.opsForHash().putIfAbsent("hash","map","hell");
        redisTemplate.opsForValue().set("hello",user);
        return "ok";
    }
}
