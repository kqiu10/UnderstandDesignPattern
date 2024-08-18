package org.behaviorPattern.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.behaviorPattern.command.impl.request.ICuisine;

public class Coordinator {
    private List<ICuisine> cuisines = new ArrayList<>();

    public void order(ICuisine cuisine) {
        cuisines.add(cuisine);
    }

    public void placeOrder() {
        for (ICuisine cuisine : cuisines) {
            cuisine.cook();
        }
        cuisines.clear();
    }
}
