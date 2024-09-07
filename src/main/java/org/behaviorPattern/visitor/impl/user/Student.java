package org.behaviorPattern.visitor.impl.user;

import java.util.Random;

import org.behaviorPattern.visitor.impl.visitor.Visitor;

public class Student extends User {
    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }

    public int count() {
        return 105 - new Random().nextInt(10);
    }
}
