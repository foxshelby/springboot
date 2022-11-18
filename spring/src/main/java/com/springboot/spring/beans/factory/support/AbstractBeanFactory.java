package com.springboot.spring.beans.factory.support;

import com.springboot.spring.beans.BeanFactory;
import com.springboot.spring.beans.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;
/**
 * @author zdd
 * @createTime 2022/11/16 13:29
 * @desc
 * @Param
 * @return
 * 2. 抽象BeanFactory实现DefaultSingletonBeanRegistry类是为了获取单例注册方法，即addSingleton()方法,实现BeanFactory是为了能够在找不到实例的情况下能够完成Bean的实例化
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * @author zdd
     * @createTime 2022/11/16 13:56
     * @desc 容器实例化的过程
     * @Param [name]
     * @return java.lang.Object
     */
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}