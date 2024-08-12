package org.structuralPattern.decorator.impl.interceptor;

public interface IHandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);
}
