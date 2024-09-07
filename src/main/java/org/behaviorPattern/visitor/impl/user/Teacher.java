package org.behaviorPattern.visitor.impl.user;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.behaviorPattern.visitor.impl.visitor.Visitor;

public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 升本率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
