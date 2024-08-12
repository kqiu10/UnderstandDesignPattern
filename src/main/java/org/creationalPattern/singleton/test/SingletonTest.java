package org.creationalPattern.singleton.test;

import org.creationalPattern.singleton.impl.SevenWays;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void create_instance_in_different_ways() {
        final SevenWays sevenWays = new SevenWays();
        sevenWays.getInstance();
    }
}
