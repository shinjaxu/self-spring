package com.github.shinjaxu.springframework;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String, Object> singletonBeanMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObj){
        singletonBeanMap.put(beanName, singletonObj);
    }
}
