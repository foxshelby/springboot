package com.springboot.spring.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:zdd
 * @Date： 2022/11/16 11:15
 * 1. 目的在于 将生成的Bean注册到Map容器中，并且提供一系列用于操作bean的方法
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
