package org.behaviorPattern.visitor.impl.user;

import org.behaviorPattern.visitor.impl.visitor.Visitor;

public abstract class User {

    public String name;
    public String identifier;
    public String clazz;

    public User(final String name, final String identifier, final String clazz) {
        this.name = name;
        this.identifier = identifier;
        this.clazz = clazz;
    }

    public abstract void accept(Visitor visitor);


}
