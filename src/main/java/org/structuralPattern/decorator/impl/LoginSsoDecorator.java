package org.structuralPattern.decorator.impl;

import org.structuralPattern.decorator.impl.interceptor.IHandlerInterceptor;
import org.structuralPattern.decorator.impl.wrapper.AbstractSsoDecorator;

public class LoginSsoDecorator extends AbstractSsoDecorator {

    public LoginSsoDecorator(final IHandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    public boolean preHandle(final String request, final String response, final Object handler, final String username) {

        super.preHandle(request, response, handler);
        log.info("preHandle method in LoginSsoDecorator is called");
        return "admin".equalsIgnoreCase(username);
    }
}
