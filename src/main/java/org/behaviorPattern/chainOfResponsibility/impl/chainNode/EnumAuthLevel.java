package org.behaviorPattern.chainOfResponsibility.impl.chainNode;

public enum EnumAuthLevel {
    ONE("10-08-2024"),
    TWO("12-12-2024"),
    THREE("25-12-2024");

    private final String date;

    EnumAuthLevel(String date) {
        this.date = date;
    }

    // Getter method for the date
    public String getDate() {
        return date;
    }
}
