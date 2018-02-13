package com.summers.integration;

import com.summers.annotation.StrategyGroup;
import com.summers.registry.StrategyRegistry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

/**
 * Created by SUMMERS on 2018/2/13.
 */
public class SpringIntegration implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> aClass = bean.getClass();
        if (!aClass.isAnnotationPresent(StrategyGroup.class)){
            return bean;
        }
        StrategyGroup annotation = aClass.getAnnotation(StrategyGroup.class);
        String group = annotation.group();
        Class interfaces = annotation.interfaces();
        String key = annotation.key();
        StrategyRegistry.register(group,key,interfaces,bean);
        return bean;
    }
}
