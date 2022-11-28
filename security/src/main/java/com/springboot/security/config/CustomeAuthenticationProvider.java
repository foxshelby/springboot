package com.springboot.security.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Author:zdd
 * @Date： 2022/11/24 15:01
 * 自定义身份验证的处理方式
 */
@Component
public class CustomeAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("开始验证自定义的provider");
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
