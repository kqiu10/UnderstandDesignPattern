package org.creationalPattern.factory.impl.services;

public class CardCommunityService implements ICommunity{

    @Override
    public String sendCommunity(String uid, String bizID) {
        return "Card vendors the customer, uid: \t" + uid + ", bizId: \t" + bizID;
    }
}
