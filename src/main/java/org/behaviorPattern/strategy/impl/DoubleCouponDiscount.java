package org.behaviorPattern.strategy.impl;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoubleCouponDiscount implements ICouponDiscount<Double> {
    private static final Logger log = LogManager.getLogger();
    @Override
    public BigDecimal discountAmount(final Double couponInfo, final BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        log.info("couponInfo: {}, discountAmount: {}", couponInfo, discountAmount);
        return discountAmount;
    }
}
