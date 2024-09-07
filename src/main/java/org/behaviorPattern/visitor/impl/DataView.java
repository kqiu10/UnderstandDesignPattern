package org.behaviorPattern.visitor.impl;

import java.util.ArrayList;
import java.util.List;

import org.behaviorPattern.visitor.impl.user.Student;
import org.behaviorPattern.visitor.impl.user.Teacher;
import org.behaviorPattern.visitor.impl.user.User;
import org.behaviorPattern.visitor.impl.visitor.Visitor;

public class DataView {
    List<User> users = new ArrayList<>();

    public DataView() {
        users.add(new Student("Xie", "basic", "1-1"));
        users.add(new Student("Windy", "Pro", "1-1"));
        users.add(new Student("Andy", "basic", "2-3"));
        users.add(new Student("Shing", "basic", "3-4"));
        users.add(new Teacher("BK", "Pro", "1-1"));
        users.add(new Teacher("Goddess", "Pro", "1-1"));
        users.add(new Teacher("Dangdang", "FullTime", "2-3"));
        users.add(new Teacher("Bran", "Intern", "3-4"));
    }

    public void show(Visitor visitor) {
        for (User user : users) {
            user.accept(visitor);
        }
    }
}
