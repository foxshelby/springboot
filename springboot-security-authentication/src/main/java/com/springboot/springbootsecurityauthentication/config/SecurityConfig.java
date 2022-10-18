package com.springboot.springbootsecurityauthentication.config;

import com.springboot.springbootsecurityauthentication.handler.FailureHandler;
import com.springboot.springbootsecurityauthentication.handler.SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/10/18 12:32
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //开启密码加密
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Resource
    private FailureHandler failureHandler;

    @Resource
    private SuccessHandler successHandler;

    //配置过滤器
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //开启HttpSecurity的配置
        http.formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/authentication/require") // 登录跳转 URL
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .successHandler(successHandler) // 处理登录成功
                .failureHandler(failureHandler) // 处理登录失败
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/authentication/require", "/login.html").permitAll() // 登录跳转 URL 无需认证
                .anyRequest()  // 所有请求
                .authenticated(); // 都需要认证


        return http.build();
    }

    //用户认证
    @Bean
    public UserDetailsService userDetailsService(){

        //创建两个用户
        UserDetails user =
                User.withUsername("root")
                        //密码1234
                        .password("$2a$10$hoUNz8qpmLlemaJIAZMfJORFJYlF6g/T5uqoWAH1BkFHhL2BMcEay")
                        .roles("ADMIN")
                        .build();

        UserDetails user1 =
                User.withUsername("user")
                        //密码1234
                        .password("$2a$10$hoUNz8qpmLlemaJIAZMfJORFJYlF6g/T5uqoWAH1BkFHhL2BMcEay")
                        .roles("USER")
                        .build();
        //这个方法接收的是UserDetails... users，所以可以传入多个user
        return new InMemoryUserDetailsManager(user,user1);
    }

}