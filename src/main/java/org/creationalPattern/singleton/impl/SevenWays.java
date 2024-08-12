package org.creationalPattern.singleton.impl;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class provides 7 different ways to create singleton instance
 * <ul>
 *     <li>Hungry initialize singleton</li>
 *     <li>Lazy initialize singleton</li>
 *     <li>synchronized initialize singleton</li>
 *     <li>double lock lazy initialize singleton</li>
 *     <li>inner class initialize singleton</li>
 *     <li>CAS initialize singleton</li>
 *     (Recommended) <li>enum initialize singleton</li>
 * </ul>
 */
public class SevenWays {

    public void getInstance() {
        HungrySingleton.getInstance();
        LazySingleton.getInstance();
        SynchronizedSingleton.getInstance();
        InnerClassSingleton.getInstance();
        DoubleLockLazySingleton.getInstance();
        CASSingleton.getInstance();
        final EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.setValue(2);
    }
}

/**
 * Provides Hungry initialize singleton
 */
class HungrySingleton {
    public static final Logger log = LogManager.getLogger(HungrySingleton.class);

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        log.info("Get instance in hungry singleton pattern");
        return instance;
    }
}

/**
 * Provides Lazy initialize singleton
 */
class LazySingleton {
    public static final Logger log = LogManager.getLogger(LazySingleton.class);

    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        log.info("Get instance in lazy singleton pattern");
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * Provides synchronized initialize singleton
 */
class SynchronizedSingleton {
    public static final Logger log = LogManager.getLogger(SynchronizedSingleton.class);

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {

    }

    public static synchronized SynchronizedSingleton getInstance() {
        log.info("Get instance in synchronized singleton pattern");
        if (null == instance) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}

/**
 * Provides double lock lazy initialize singleton
 */
class DoubleLockLazySingleton {
    public static final Logger log = LogManager.getLogger();
    private static volatile DoubleLockLazySingleton instance;

    private DoubleLockLazySingleton() {

    }

    public static DoubleLockLazySingleton getInstance() {
        if (null != instance) {
            return instance;
        }
        synchronized (DoubleLockLazySingleton.class) {
            if (null == instance) {
                instance = new DoubleLockLazySingleton();
            }
        }
        return instance;
    }

}

/**
 * Provides inner class initialize singleton
 */
class InnerClassSingleton {
    private static final Logger log = LogManager.getLogger();

    private InnerClassSingleton() {

    }

    private static class InnerClass {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        log.info("Get instance in InnerClass singleton pattern");
        return InnerClass.instance;
    }
}

/**
 * Provides CAS initialize singleton
 */
class CASSingleton {
    private static final Logger log = LogManager.getLogger();
    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton() {

    }

    public static CASSingleton getInstance() {
        for (; ; ) {
            final CASSingleton instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }
            log.info("Get instance in CAS singleton pattern");
            INSTANCE.compareAndSet(null, new CASSingleton());
            return INSTANCE.get();
        }
    }

}

/**
 * Provides enum initialize singleton
 */
enum EnumSingleton {
    INSTANCE;

    int value;
    private static final Logger log = LogManager.getLogger();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        log.info("Get instance in Enum singleton pattern");
        this.value = value;
    }
}