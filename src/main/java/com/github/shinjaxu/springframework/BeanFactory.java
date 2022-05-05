package com.github.shinjaxu.springframework;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String name){
      return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition bean){
        beanDefinitionMap.put(name, bean);
    }

}
