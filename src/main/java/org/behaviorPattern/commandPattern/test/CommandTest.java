package org.behaviorPattern.commandPattern.test;

import org.behaviorPattern.commandPattern.impl.Coordinator;
import org.behaviorPattern.commandPattern.impl.execute.PastaCook;
import org.behaviorPattern.commandPattern.impl.execute.SteakCook;
import org.behaviorPattern.commandPattern.impl.request.ICuisine;
import org.behaviorPattern.commandPattern.impl.request.Pasta;
import org.behaviorPattern.commandPattern.impl.request.Steak;
import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    public void test_Order_Correct() {
        final Coordinator coordinator = new Coordinator();
        final ICuisine steak = new Steak(new SteakCook());
        final ICuisine pasta = new Pasta(new PastaCook());
        coordinator.order(steak);
        coordinator.order(pasta);
        coordinator.placeOrder();
    }
}
