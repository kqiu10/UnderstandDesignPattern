package org.creationalPattern.abstractFactory.impl.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.creationalPattern.abstractFactory.impl.ICacheAdapter;

public class JDKProxyFactory {

    public static <T> T getProxy(Class<T> cacheClazz, Class<? extends ICacheAdapter> cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{cacheClazz}, handler);
    }
}
