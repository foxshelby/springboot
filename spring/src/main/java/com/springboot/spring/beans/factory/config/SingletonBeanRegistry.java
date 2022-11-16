package com.springboot.spring.beans.factory.config;

/**
 * @author zdd
 * @createTime 2022/11/16 13:26
 * @desc
 * @Param
 * @return
 * 2. 单例注册接口，用于返回具体的单例对象
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}