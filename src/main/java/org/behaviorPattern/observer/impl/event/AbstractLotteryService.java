package org.behaviorPattern.observer.impl.event;

import org.behaviorPattern.observer.impl.LotteryResult;
import org.behaviorPattern.observer.impl.event.listener.MQEventListener;
import org.behaviorPattern.observer.impl.event.listener.MessageEventListener;

public abstract class AbstractLotteryService {
    private EventManager eventManager;

    public AbstractLotteryService() {
       eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.MESSAGE);
       eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
       eventManager.subscribe(EventManager.EventType.MESSAGE, new MessageEventListener());
    }

    /**
     * Observer design pattern steps in: separate methods doing lottery and methods listening to the lottery result.
     */
    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.MESSAGE, lotteryResult);
        return lotteryResult;
    }

    /**
     * Return lottery result
     */
    protected abstract LotteryResult doDraw(String uId);
}
