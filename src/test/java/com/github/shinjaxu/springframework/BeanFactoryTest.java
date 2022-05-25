package com.github.shinjaxu.springframework;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.Map;

import static org.junit.Assert.*;

public class BeanFactoryTest {
    BeanFactory factory;

    @Before
    public void init(){
        factory = new BeanFactory();
        UserService userService = new UserService();
        BeanDefinition userServiceDef = new BeanDefinition(userService);
        factory.registerBeanDefinition("userService", userServiceDef);
    }

    @Test
    public void getBean() {
        UserService userService = (UserService) factory.getBean("userService");
        assertSame("Object of method #getBean is not need", UserService.class, userService.getClass());
        assertSame("the output is error", "用户A", userService.queryUser());
    }

    @Test
    public void registerBeanDefinition() {
        Map<String, BeanDefinition> beanDefinitionMap =
                Whitebox.getInternalState(factory, "beanDefinitionMap");
        assertEquals("the \"beanDefinitionMap\" Map should be 1", 1, beanDefinitionMap.size());

    }

    private class UserService{
        public String queryUser(){
            return "用户A";
        }
    }
}