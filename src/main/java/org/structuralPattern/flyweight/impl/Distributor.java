package org.structuralPattern.flyweight.impl;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Distributor implements Runnable {
    private static final Random rnd = new Random();
    private static final Logger log = LogManager.getLogger();

    private final Stock stock;
    private final CountDownLatch latch;

    public Distributor(final Stock stock, final CountDownLatch latch) {
        this.stock = stock;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int val = rnd.nextInt(30);
            log.info(Thread.currentThread().getName() + "\t divide: \t" + val);
            stock.divide(val);
            // Pause the current thread for some random time to simulate latency between client and server
            TimeUnit.MILLISECONDS.sleep(rnd.nextInt(2000) + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
        }

    }
}
