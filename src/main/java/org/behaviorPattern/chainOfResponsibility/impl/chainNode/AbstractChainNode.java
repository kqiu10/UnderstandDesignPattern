package org.behaviorPattern.chainOfResponsibility.impl.chainNode;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractChainNode {

    protected static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    protected AbstractChainNode next;

    protected AuthInfo authInfo;
    protected String levelUserId;
    protected String levelUserName;

    public AbstractChainNode(final String levelUserId, final String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AbstractChainNode getNext() {
        return next;
    }

    public void setNext(final AbstractChainNode next) {
        this.next = next;
    }

    public abstract AuthInfo doAuth(String levelUserId, String levelUserName, Date authDate);
}
