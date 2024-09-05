package org.behaviorPattern.observer.test;

import org.behaviorPattern.observer.impl.event.AbstractLotteryService;
import org.behaviorPattern.observer.impl.event.LotteryServiceImpl;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void test_observer_run_with_two_listener() {
        AbstractLotteryService lotteryService = new LotteryServiceImpl();

        final String uId = "1000001";
        lotteryService.draw(uId);
    }
}
