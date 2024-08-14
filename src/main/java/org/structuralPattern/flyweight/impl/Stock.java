package org.structuralPattern.flyweight.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stock {
    private static final Logger log = LogManager.getLogger();
    private final AtomicLong storage;

    public Stock(final long storage) {
        this.storage = new AtomicLong(storage);
    }

    public void divide(long num) {
        while (true) {
            final long cur = storage.get();
            if (cur < num) {
                log.info(Thread.currentThread().getName() + "\t noticed Insufficient storage left, remaining {}", storage.get());
                if (cur > 0) {
                    log.info("Decrement storage by 1 to avoid infinite loop");
                    // In case multiple threads reach at the same point, check if storage value is unchanged before decrement
                    if (storage.compareAndSet(cur, cur - 1)) {
                        // Successfully decremented by 1
                        break;
                    }
                } else {
                    // If storage is 0, break to avoid further decrements
                    break;
                }
            } else {
                if (storage.compareAndSet(cur, cur - num)) {
                    break;
                }
            }
            // If compareAndSet fails, another thread modified storage, retry the loop
        }

    }

    public long getStorage() {
        return storage.get();
    }
}
