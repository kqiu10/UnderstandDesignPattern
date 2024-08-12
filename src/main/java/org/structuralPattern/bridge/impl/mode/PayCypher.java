package org.structuralPattern.bridge.impl.mode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayCypher implements IPayMode {
    private static final Logger log = LogManager.getLogger();
    @Override
    public boolean security(final String uid) {
        log.info("Pay successfully with cypher");
        return true;
    }
}
