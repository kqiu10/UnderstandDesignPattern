package org.structuralPattern.flyweight.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.structuralPattern.flyweight.impl.DistributorController;

public class FlyweightTest {

    @Test
    public void test_Stock_distributed_correctly() {
        final DistributorController distributorController = new DistributorController();
        final long remainingStorage = distributorController.distribute();
        assertEquals(0L, remainingStorage);
    }
}
