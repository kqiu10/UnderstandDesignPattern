package org.behaviorPattern.state.impl;

public abstract class AbstractState {

    public enum Status {
        Editing,
        Check,
        Pass,
        Refuse
    }

    public abstract Result arraignment(String activityId, Status currentStatus);
    public abstract Result checkPass(String activityId, Status currentStatus);
    public abstract Result checkRefuse(String activityId, Status currentStatus);

}
