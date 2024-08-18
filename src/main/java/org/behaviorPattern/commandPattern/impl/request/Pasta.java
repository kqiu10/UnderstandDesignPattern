package org.behaviorPattern.commandPattern.impl.request;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.commandPattern.impl.execute.ICook;

public class Pasta implements ICuisine {
    private static final Logger log = LogManager.getLogger();

    private final ICook cook;

    public Pasta(final ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        log.info("Order pasta");
        cook.doCooking();
    }
}
