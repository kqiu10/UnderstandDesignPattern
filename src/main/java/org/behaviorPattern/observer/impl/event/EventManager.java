package org.behaviorPattern.observer.impl.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.behaviorPattern.observer.impl.LotteryResult;
import org.behaviorPattern.observer.impl.event.listener.EventListener;

public class EventManager {
    public enum EventType {
        MQ,
        MESSAGE;
    }

    Map<EventType, List<EventListener>> listeners = new HashMap<>();

    public EventManager(EventType... operations) {
        for (EventType operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(EventType eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void unSubscribe(EventType eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(EventType eventType, LotteryResult lotteryResult) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(lotteryResult);
        }
    }
}
