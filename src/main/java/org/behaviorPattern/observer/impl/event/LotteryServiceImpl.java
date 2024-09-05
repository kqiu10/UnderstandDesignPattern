package org.behaviorPattern.observer.impl.event;

import java.util.Date;
import java.util.Random;

import org.behaviorPattern.observer.impl.LotteryResult;

public class LotteryServiceImpl extends AbstractLotteryService {
    private static final Random rnd = new Random();
    @Override
    protected LotteryResult doDraw(final String uId) {
        String lottery = String.valueOf(rnd.nextInt(10000) + 100);
        return new LotteryResult(uId, lottery, new Date());
    }
}
