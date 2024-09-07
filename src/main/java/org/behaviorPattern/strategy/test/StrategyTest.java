package org.behaviorPattern.strategy.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.behaviorPattern.strategy.impl.Context;
import org.behaviorPattern.strategy.impl.DoubleCouponDiscount;
import org.behaviorPattern.strategy.impl.IntegerCouponDiscount;
import org.behaviorPattern.strategy.impl.MapCouponDiscount;
import org.junit.jupiter.api.Test;

public class StrategyTest {

    @Test
    public void test_integer_strategies_works() {
        final Context<Integer> context = new Context<>(new IntegerCouponDiscount());
        context.calculateDiscount(10, BigDecimal.valueOf(100.0));
    }

    @Test
    public void test_double_strategies_works() {
        final Context<Double> context = new Context<>(new DoubleCouponDiscount());
        context.calculateDiscount(10.0, BigDecimal.valueOf(77.7));
    }

    @Test
    public void test_map_strategies_works() {
        final Context<Map<String, Double>> context = new Context<>(new MapCouponDiscount());
        Map<String, Double> contextMap = new HashMap<>();
        contextMap.put("S", 40.0);
        context.calculateDiscount(contextMap, BigDecimal.valueOf(100.0));
    }
}
