package org.behaviorPattern.state.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ActivityService {
    private ActivityService() {};

    private static Map<String, AbstractState.Status> statusMap = new HashMap<>();

    public static void init(String activityId, AbstractState.Status status) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("Rewarding");
        activityInfo.setStatus(status);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        statusMap.put(activityId, status);
    }

    public static ActivityInfo queryActivityInfo(String activityId) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("Rewarding");
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    public static AbstractState.Status queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }

    public static synchronized void execStatus(String activityId, AbstractState.Status beforeStatus, AbstractState.Status afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId, afterStatus);
    }

}
