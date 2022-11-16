package com.springboot.spring.beans.factory.support;

import com.springboot.spring.beans.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
/**
 * @author zdd
 * @createTime 2022/11/16 13:32
 * @desc
 * @Param
 * @return
 * 2. 这里完成了Bean的实例化过程
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanDefinitionStoreException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

}