package com.springboot.security.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/11/24 14:49
 * 自定义身份验证管理器
 */
@Component
public class CustumeAuthenticationManager implements AuthenticationManager {
    @Resource
    private CustomeAuthenticationProvider customeAuthenticationProvider;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //进入自定义的providerManager
        System.out.println("进入自定义的providerManager");
        return customeAuthenticationProvider.authenticate(authentication);
    }
}
