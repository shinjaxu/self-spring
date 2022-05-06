package com.github.shinjaxu.springframework;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
