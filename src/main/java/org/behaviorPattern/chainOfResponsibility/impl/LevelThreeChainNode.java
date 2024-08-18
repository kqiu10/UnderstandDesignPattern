package org.behaviorPattern.chainOfResponsibility.impl;

import java.text.ParseException;
import java.util.Date;

import org.behaviorPattern.chainOfResponsibility.impl.chainNode.AbstractChainNode;
import org.behaviorPattern.chainOfResponsibility.impl.chainNode.AuthInfo;
import org.behaviorPattern.chainOfResponsibility.impl.chainNode.EnumAuthLevel;

public class LevelThreeChainNode extends AbstractChainNode {

    private final Date lastDay = format.parse(EnumAuthLevel.THREE.getDate());

    public LevelThreeChainNode(final String levelUserId, final String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(final String levelUserId, final String levelUserName, final Date authDate) {
        if (authDate.after(lastDay)) {
           throw new IllegalStateException(String.format("AuthDate %s is out of range", format.format(authDate)));
        }
        return new AuthInfo(levelUserId, levelUserName, EnumAuthLevel.THREE);
    }
}
