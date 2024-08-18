package org.behaviorPattern.command.impl.execute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SteakCook implements ICook {
    private static final Logger log = LogManager.getLogger();
    @Override
    public void doCooking() {
        log.info("Cooking steak");
    }
}
