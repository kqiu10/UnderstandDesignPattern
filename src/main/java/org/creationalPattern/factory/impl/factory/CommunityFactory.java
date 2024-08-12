package org.creationalPattern.factory.impl.factory;

import java.util.Random;

import org.creationalPattern.factory.impl.awards.CardCommunityService;
import org.creationalPattern.factory.impl.awards.CouponCommunityService;
import org.creationalPattern.factory.impl.awards.CashCommunityService;
import org.creationalPattern.factory.impl.awards.ICommunity;

public class CommunityFactory {

    private static Random rnd = new Random();
    enum AwardType {
        CASH, CARD, COUPON;
    }

    public String getCommunityFactory(final String awardType) throws IllegalAccessException, InstantiationException {
        final String uid = rnd.nextInt(500) + "";
        final String bizID = rnd.nextInt(999999) + "";
        ICommunity community = vendorService(awardType);
//        ICommunity community = getCommodityService(CardCommunityService.class);
        return community.sendCommunity(uid, bizID);
    }
    private ICommunity vendorService(final String awardType) {
        AwardType type = AwardType.valueOf(awardType);
        switch (type) {
        case CARD:
            return new CardCommunityService();
        case CASH:
            return new CashCommunityService();
        case COUPON:
            return new CouponCommunityService();
        default:
            throw new IllegalStateException("AwardType sent is incorrect");
        }
    }

    private ICommunity getCommodityService(Class<? extends ICommunity> clazz) throws IllegalAccessException,
            InstantiationException {
        if (null == clazz) return null;
        return clazz.newInstance();
    }

}
