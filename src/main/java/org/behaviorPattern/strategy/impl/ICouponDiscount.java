package org.behaviorPattern.strategy.impl;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}
