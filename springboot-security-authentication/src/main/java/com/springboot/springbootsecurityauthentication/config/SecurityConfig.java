package com.springboot.springbootsecurityauthentication.config;

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

    //配置过滤器
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //开启HttpSecurity的配置
        http.authorizeRequests()
                //访问/admin/**模式的url必须具备admin的角色
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')")
                .anyRequest().authenticated().and()
                //开启表单验证
                .formLogin();

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