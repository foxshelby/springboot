package com.springboot.security.config;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @Author:zdd
 * @Date： 2022/11/28 13:07
 */
@Component
public class CustomeAuthorizationManager implements AuthorizationManager {
    @Override
    public AuthorizationDecision check(Supplier authentication, Object object) {
        return null;
    }

    @Override
    public void verify(Supplier authentication, Object object) {
        AuthorizationManager.super.verify(authentication, object);
    }
}
