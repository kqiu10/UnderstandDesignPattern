package org.behaviorPattern.chainOfResponsibility.impl;

import java.text.ParseException;
import java.util.Date;

import org.behaviorPattern.chainOfResponsibility.impl.chainNode.AbstractChainNode;
import org.behaviorPattern.chainOfResponsibility.impl.chainNode.AuthInfo;
import org.behaviorPattern.chainOfResponsibility.impl.chainNode.EnumAuthLevel;

public class LevelOneChainNode extends AbstractChainNode {
    private final Date lastDay = format.parse(EnumAuthLevel.ONE.getDate());

    public LevelOneChainNode(final String levelUserId, final String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(final String levelUserId, final String levelUserName, final Date authDate) {
        if (authDate.before(lastDay)) {
            return new AuthInfo(levelUserId, levelUserName, EnumAuthLevel.ONE);
        } else {
            return this.getNext().doAuth(levelUserId, levelUserName, authDate);
        }
    }
}
