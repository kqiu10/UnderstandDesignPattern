package org.behaviorPattern.commandPattern.impl.execute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PastaCook implements ICook {
    private static final Logger log = LogManager.getLogger();

    @Override
    public void doCooking() {
        log.info("Cooking pasta");
    }
}
