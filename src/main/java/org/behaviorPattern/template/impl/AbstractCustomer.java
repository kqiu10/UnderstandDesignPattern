package org.behaviorPattern.template.impl;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractCustomer {
    protected static final Logger log = LogManager.getLogger();
    protected static final Random rnd = new Random();

    String uId;
    String uPwd;

    public AbstractCustomer(final String uId, final String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    protected abstract Boolean login(String uid, String uPwd);

    protected abstract String createBase64(String identifier);

    protected abstract String createIdentifier();

    public String generateRandomIdentifier() {
        if (!login(uId, uPwd)) {
            return null;
        }
        final String identifier = createIdentifier();
        return createBase64(identifier);
    }
}
