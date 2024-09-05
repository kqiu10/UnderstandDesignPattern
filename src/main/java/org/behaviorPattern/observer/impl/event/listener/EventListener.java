package org.behaviorPattern.observer.impl.event.listener;

import org.behaviorPattern.observer.impl.LotteryResult;

public interface EventListener {

    void doEvent(LotteryResult result);
}
