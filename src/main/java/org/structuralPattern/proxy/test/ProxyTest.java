package org.structuralPattern.proxy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.structuralPattern.proxy.impl.IUserDao;

public class ProxyTest {

    @Test
    public void test_SQL_handle_request_successfully() {
        final BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        final String res = userDao.queryUserInfo("10001");
        assertEquals("10001 is handled by SQL", res);
    }
}
