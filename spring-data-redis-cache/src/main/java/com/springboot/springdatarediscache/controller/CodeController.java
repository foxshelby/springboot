package com.springboot.springdatarediscache.controller;

import com.springboot.springdatarediscache.entity.Code;
import com.springboot.springdatarediscache.service.ICodeService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-10-17
 */
@RestController
@RequestMapping("/system/code")
public class CodeController {

    @Resource
    private ICodeService iCodeService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/v1/{code}")
    public String list(@PathVariable("code") String code) {
        iCodeService.getByCode(code);
        return "ok";
    }

    @GetMapping("/v1/add")
    public String add(Code code) {
        Object o = redisTemplate.opsForValue().get("cacheManager::12");
        return "ok";
    }
}
