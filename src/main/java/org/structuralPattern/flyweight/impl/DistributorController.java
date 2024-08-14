package org.structuralPattern.flyweight.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DistributorController {

    private static Stock stock;
    private static final Logger log = LogManager.getLogger();

    static {
        stock = new Stock(100);
    }

    public long distribute() {
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        final int nThreads = 10;

        try {
            while (stock.getStorage() > 0) {
                CountDownLatch latch = new CountDownLatch(nThreads);
                for (int i = 0; i < nThreads; i++) {
                    executor.submit(new Distributor(stock, latch));
                }
                log.info("Waiting for current batch complete");
                latch.await();
                // Pause the main thread for a period of time to simulate latency between client and server
                TimeUnit.MILLISECONDS.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
        return stock.getStorage();
    }
}
