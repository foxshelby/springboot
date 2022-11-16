package com.springboot.spring.beans.factory.config;

/**
 * @Author:zdd
 * @Date： 2022/11/16 11:15
 * 1. 现在用于 包装装入到容器中的对象
 * 2. 现在传递的是类对象，将实例化过程交给容器完成
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
