package org.behaviorPattern.iterator.impl;

public class Link {
    private String fromId;
    private String toId;

    public Link(final String fromId, final String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(final String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(final String toId) {
        this.toId = toId;
    }
}
