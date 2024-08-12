package org.creationalPattern.factory.impl.awards;

public class CouponCommunityService implements ICommunity {

    @Override
    public String sendCommunity(String uid, String bizID) {
        return "Coupon vendors the customer, uid: \t" + uid + ", bizId: \t" + bizID;    }
}
