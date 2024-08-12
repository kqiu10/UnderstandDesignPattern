package org.structuralPattern.bridge.impl.mode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayFaceMode implements IPayMode {
    private static final Logger log = LogManager.getLogger();
    @Override
    public boolean security(final String uid) {
        log.info("Pay successfully with face");
        return true;
    }
}
