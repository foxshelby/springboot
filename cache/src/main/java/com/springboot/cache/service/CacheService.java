package com.springboot.cache.service;

import com.springboot.cache.entity.Cache;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author:zdd
 * @Date： 2022/11/15 14:38
 */
public interface CacheService {

    @Cacheable(value = "redis", key = "#p0", cacheManager = "cacheManager")
    Cache getObject(String s);
}
