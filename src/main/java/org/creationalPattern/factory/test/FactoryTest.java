package org.creationalPattern.factory.test;

import org.creationalPattern.factory.impl.factory.CommunityFactory;
import org.junit.jupiter.api.Test;

public class FactoryTest {
    @Test
    void returnStringWithDifferentFactory() throws Exception {
        final CommunityFactory factory = new CommunityFactory();

        System.out.println(factory.getCommunityFactory("COUPON"));
        System.out.println(factory.getCommunityFactory("CASH"));
        System.out.println(factory.getCommunityFactory("CARD"));
    }


}
