package org.behaviorPattern.strategy.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MapCouponDiscount implements ICouponDiscount<Map<String, Double>> {
    private static final Logger log = LogManager.getLogger();

    private static final String SIGNAL = "S";
    @Override
    public BigDecimal discountAmount(final Map<String, Double> couponInfo, final BigDecimal skuPrice) {
        Double discount = couponInfo.get(SIGNAL);
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(discount));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        log.info("couponInfo: {}, discountAmount: {}", discount, discountAmount);

        return discountAmount;
    }
}
