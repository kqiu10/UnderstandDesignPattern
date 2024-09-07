package org.behaviorPattern.strategy.impl;

import java.math.BigDecimal;

public class Context<T> {
    final ICouponDiscount<T> iCouponDiscount;

    public Context(final ICouponDiscount<T> iCouponDiscount) {
        this.iCouponDiscount = iCouponDiscount;
    }

    public void calculateDiscount(final T couponInfo, BigDecimal price) {
        iCouponDiscount.discountAmount(couponInfo, price);
    }
}
