package com.springboot.spring.beans.factory.support;

import com.springboot.spring.beans.BeansException;
import com.springboot.spring.beans.factory.config.BeanDefinition;
import com.springboot.spring.beans.factory.support.AbstractAutowireCapableBeanFactory;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zdd
 * @createTime 2022/11/16 13:33
 * @desc
 * @Param
 * @return
 *
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

}