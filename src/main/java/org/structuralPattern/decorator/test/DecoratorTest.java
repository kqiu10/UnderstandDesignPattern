package org.structuralPattern.decorator.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.structuralPattern.decorator.impl.LoginSsoDecorator;
import org.structuralPattern.decorator.impl.interceptor.SsoInterceptor;

public class DecoratorTest {

    @Test
    public void test_Decorator_return_true() {
        final LoginSsoDecorator loginSsoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successHaHa";
        final boolean testWithoutDecorator = loginSsoDecorator.preHandle(request, "ewitodhinfk", "t");
        assertTrue(testWithoutDecorator);
        final boolean testWithDecorator = loginSsoDecorator.preHandle(request, "dfhgruerogm", "t", "admin");
        assertTrue(testWithDecorator);
    }
}
