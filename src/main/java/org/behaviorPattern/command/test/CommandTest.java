package org.behaviorPattern.command.test;

import org.behaviorPattern.command.impl.Coordinator;
import org.behaviorPattern.command.impl.execute.PastaCook;
import org.behaviorPattern.command.impl.execute.SteakCook;
import org.behaviorPattern.command.impl.request.ICuisine;
import org.behaviorPattern.command.impl.request.Pasta;
import org.behaviorPattern.command.impl.request.Steak;
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
