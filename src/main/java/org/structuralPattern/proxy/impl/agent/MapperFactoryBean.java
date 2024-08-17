package org.structuralPattern.proxy.impl.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private static final Logger log = LogManager.getLogger();

    private Class<T> mapperInterface;

    public MapperFactoryBean(final Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler hanlder = ((proxy, method, args) -> {
            Select select = method.getAnnotation(Select.class);
            log.info("SQL: {}", select.value().replace("#{uId}", args[0].toString()));
            return args[0] + " is handled by SQL";
        });
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, hanlder);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
