package com.springboot.springbootsecurityauthentication.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:zdd
 * @Date： 2022/10/18 12:30
 * 登录成功的重定向设置
 */
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private RedirectStrategy redirectStrategy;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        redirectStrategy.sendRedirect(request,response,"/form");
    }
}