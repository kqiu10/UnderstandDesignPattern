package org.creationalPattern.abstractFactory.impl.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.creationalPattern.abstractFactory.impl.ICacheAdapter;
import org.creationalPattern.abstractFactory.impl.util.ClassLoaderUtils;

public class JDKInvocationHandler implements InvocationHandler {

    private final ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(final ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
