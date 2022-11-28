package com.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zdd
 * @Date： 2022/11/24 10:52
 */
@RestController
public class TestController {

    @GetMapping("/admin/test")
    public void a(){
        System.out.println("dsds");
    }

    @GetMapping("/public/test")
    public void b(){
        System.out.println("bbbb");
    }
}
