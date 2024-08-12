package org.structuralPattern.decorator.impl.wrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.structuralPattern.decorator.impl.interceptor.IHandlerInterceptor;

public abstract class AbstractSsoDecorator implements IHandlerInterceptor {
    protected static final Logger log = LogManager.getLogger();

    private final IHandlerInterceptor handlerInterceptor;


    public AbstractSsoDecorator(final IHandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(final String request, final String response, final Object handler) {
        log.info("preHandle method in AbstractSsoDecorator is called");
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
