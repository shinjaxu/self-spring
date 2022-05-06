package com.github.shinjaxu.springframework;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements BeanFactory{
    @Override
    public Object getBean(String name) {
        Object obj = getSingleton(name);
        if(obj != null){
            return obj;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    public abstract BeanDefinition getBeanDefinition(String beanName);

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
