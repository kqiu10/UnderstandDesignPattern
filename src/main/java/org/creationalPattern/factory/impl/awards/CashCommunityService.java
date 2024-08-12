package org.creationalPattern.factory.impl.awards;

public class CashCommunityService implements ICommunity{

    @Override
    public String sendCommunity(String uid, String bizID) {
        return "Cash vendors the customer, uid: \t" + uid + ", bizId: \t" + bizID;    }
}
