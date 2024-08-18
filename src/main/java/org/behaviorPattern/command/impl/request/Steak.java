package org.behaviorPattern.command.impl.request;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.command.impl.execute.ICook;

public class Steak implements ICuisine {
    private static final Logger log = LogManager.getLogger();

    private final ICook cook;

    public Steak(final ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        log.info("Order steak");

        cook.doCooking();
    }
}
