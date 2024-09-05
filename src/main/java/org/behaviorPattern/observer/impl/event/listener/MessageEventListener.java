package org.behaviorPattern.observer.impl.event.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.observer.impl.LotteryResult;

public class MessageEventListener implements EventListener {
    private static final Logger log = LogManager.getLogger();

    @Override
    public void doEvent(final LotteryResult result) {
        log.info("Send Message {} to user {}", result.getMsg(), result.getuId());
    }
}
