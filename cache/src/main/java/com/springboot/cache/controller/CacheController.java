package com.springboot.cache.controller;

import com.springboot.cache.entity.Cache;
import com.springboot.cache.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/11/15 14:39
 */
@RestController
public class CacheController {

    @Resource
    private CacheService cacheService;

    @GetMapping("/test")
    public void cache() {
        Cache cache = cacheService.getObject("1");
        System.out.println(cache);
    }
}
