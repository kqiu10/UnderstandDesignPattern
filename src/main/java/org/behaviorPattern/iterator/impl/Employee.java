package org.behaviorPattern.iterator.impl;

public class Employee {

    private String uId;
    private String name;
    private String desc;

    public Employee(final String uId, final String name) {
        this.uId = uId;
        this.name = name;
    }

    public Employee(final String uId, final String name, final String desc) {
        this.uId = uId;
        this.name = name;
        this.desc = desc;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(final String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }
}
