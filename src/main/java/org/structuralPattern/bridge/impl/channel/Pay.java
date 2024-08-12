package org.structuralPattern.bridge.impl.channel;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.structuralPattern.bridge.impl.mode.IPayMode;

public abstract class Pay {
    protected static final Logger log = LogManager.getLogger();
    protected IPayMode payMode;

    public Pay(final IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uid, String tradeId, BigDecimal amount);
}
