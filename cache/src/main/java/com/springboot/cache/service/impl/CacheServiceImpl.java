package com.springboot.cache.service.impl;

import com.springboot.cache.entity.Cache;
import com.springboot.cache.service.CacheService;
import org.springframework.stereotype.Service;

/**
 * @Author:zdd
 * @Date： 2022/11/15 14:38
 */
@Service
public class CacheServiceImpl implements CacheService {
    int i = 0;
    @Override
    public Cache getObject(String s) {
        Cache cache = new Cache();
        cache.setPassword(s);
        cache.setUsername("123");
        System.out.println(i++);
        return cache;
    }
}
