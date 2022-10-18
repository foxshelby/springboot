package com.springboot.springbootsecurityauthentication.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:zdd
 * @Date： 2022/10/18 12:26
 * 设置验证失败的处理方法
 */
@Component
public class FailureHandler implements AuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy() ;

    /**
     * @author zdd
     * @createTime 2022/10/18 12:29
     * @desc  重定向到 登录失败的页面
     * @Param [request, response, exception]
     * @return void
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        redirectStrategy.sendRedirect(request,response,"/failure");
    }
}
