package org.structuralPattern.decorator.impl.interceptor;

public class SsoInterceptor implements IHandlerInterceptor {
    @Override
    public boolean preHandle(final String request, final String response, final Object handler) {
        String ticket = request.substring(1, 8);
        return "success".equalsIgnoreCase(ticket);
    }
}
