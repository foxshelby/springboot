package com.springboot.security.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.apache.catalina.connector.RequestFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.access.intercept.aspectj.AspectJMethodSecurityInterceptor;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import sun.security.util.SecurityProperties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zdd
 * @Date： 2022/11/24 8:50
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Resource
    private CustumeAuthenticationManager custumeAuthenticationManager;

    @Resource
    private CustomeAuthenticationProvider customeAuthenticationProvider;

    @Resource
    private CustomeAccessDecisionManager customeAccessDecisionManager;
    @Resource
    private CustomeAuthorizationManager customeAuthorizationManager;

    /**
     * @return org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
     * @author zdd
     * @createTime 2022/11/28 11:15
     * @desc
     * @Param []
     */
    @Bean
    public WebSecurityCustomizer webSecurity() {
        Log log = LogFactory.getLog(AbstractSecurityInterceptor.class);
        log.debug("true");
        return (web) -> web.debug(true).ignoring()
                // ignore all URLs that start with /resources/ or /static/
                .antMatchers("/resources/**", "/static/**");
    }

    /**
     * @return org.springframework.security.web.SecurityFilterChain
     * @author zdd
     * @createTime 2022/11/28 11:15
     * @desc
     * @Param [http]
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authenticationManager(custumeAuthenticationManager)
//                //将自定义的身份验证provider 添加到authenticationManager的list
//                .authenticationProvider(customeAuthenticationProvider)
                http.authorizeRequests().antMatchers("/admin/**").permitAll()
                        .accessDecisionManager(customeAccessDecisionManager)
                .anyRequest()
                .hasRole("USER").and()
//                .authorizeRequests().antMatchers().access("hasRole(USER)")
//                .formLogin() // enable form based log in

                        .httpBasic();
        return http.build();
    }

    /**
     * 配置篇
     * 1. 开启formLogin() 方法 会将UsernamePasswordAuthenticationFilter() 过滤器添加到过滤链中 内部的方法调用 AuthenticationManager对象的authenticate()方法进行身份校验
     *
     */


    /**
     * 身份验证篇
     * 1. AuthenticationManager    用于身份验证的入口类  authenticate(Authentication authentication) 方法用于校验   默认实现类是ProviderManager 内部定义了一个AuthenticationProvider类的列表
     *  用于实现不同类型的身份校验
     * 2. AuthenticationProvider  内部的接口方法用于自定义授权接口   即实际对用户的身份进行校验的方法   常见实现类是DaoAuthenticationProvider   就是常见的用户名密码登录的方式
     *
     *
     * 自定义AuthenticationManager
     * 1. 创建自定义的AuthenticationManger 实现AuthenticationManager接口，并实现自己的方法
     * 2. 创建自定义的AuthenticationProvider 实现AuthenticationProvider接口  并实现方法
     * 3. 在自定义的AuthenticationManger 中装配自定义的AuthenticationProvider 对象并调用authenticate()方法
     * 4. 在配置类中声明使用的AuthenticationManager并显示配置自定义的provider即可完成身份验证
     */


    /**
     * 授权篇
     * 1. AuthorizationManager 用于校验用户是否拥有对应的权限
     * 2. GrantedAuthority 定义了获得用户当前的权限
     * 3. AccessDecisionManager 用来判断当前的url是否能够被允许进行访问
     * 4.AccessDecisionVoter 类似于身份验证篇的provider  AccessDecisionManager中维护了一个Voter列表，会循环来投票决定是否允许访问
     */

    /**
     * attemptAuthorization 会在拦截器中调用这个方法进行授权操作
     */


    /**
     * 加密篇
     * 1.
     */
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        return new InMemoryUserDetailsManager(new User("user", "password", new ArrayList<>()));
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Resource
//    private MethodSecurityInterceptor methodSecurityInterceptor;
//
//    public void a(){
//        methodSecurityInterceptor.setAccessDecisionManager(customeAccessDecisionManager);
//
//    }

}
