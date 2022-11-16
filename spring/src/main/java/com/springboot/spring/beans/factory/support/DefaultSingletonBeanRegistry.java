package com.springboot.spring.beans.factory.support;

import com.springboot.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdd
 * @createTime 2022/11/16 13:27
 * @desc
 * @Param
 * @return
 * 2. 提供了一个默认的单例注册接口实现类，并增加了一个受保护的增加方法，用于像容器中添加单例对象
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}