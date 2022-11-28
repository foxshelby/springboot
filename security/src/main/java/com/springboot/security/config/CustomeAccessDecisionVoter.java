package com.springboot.security.config;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author:zdd
 * @Date： 2022/11/28 13:09
 */
@Component
public class CustomeAccessDecisionVoter implements AccessDecisionVoter {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection collection) {
        return 0;
    }

    @Override
    public boolean supports(Class clazz) {
        return false;
    }
}
