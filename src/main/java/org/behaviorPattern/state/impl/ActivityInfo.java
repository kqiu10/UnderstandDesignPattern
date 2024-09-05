package org.behaviorPattern.state.impl;

import java.util.Date;

public class ActivityInfo {

    private String activityId;
    private String activityName;
    private AbstractState.Status status;
    private Date beginTime;
    private Date endTime;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(final String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(final String activityName) {
        this.activityName = activityName;
    }

    public AbstractState.Status getStatus() {
        return status;
    }

    public void setStatus(final AbstractState.Status status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(final Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }
}
