package com.springboot.spring.bean;

/**
 * @Author:zdd
 * @Date： 2022/11/16 11:15
 * 1. 现在用于 包装装入到容器中的对象
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
