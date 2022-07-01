package com.pgt.chainResponsibility.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class StaticMethodGetBean<T> implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        StaticMethodGetBean.applicationContext = applicationContext;
    }
    public static <T> T getBean(String clazz){
        return applicationContext!=null? (T) applicationContext.getBean(clazz) :null;
    }
}
