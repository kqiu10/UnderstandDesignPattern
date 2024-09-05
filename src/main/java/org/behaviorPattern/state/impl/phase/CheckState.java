package org.behaviorPattern.state.impl.phase;

import org.behaviorPattern.state.impl.AbstractState;
import org.behaviorPattern.state.impl.ActivityService;
import org.behaviorPattern.state.impl.Result;

public class CheckState extends AbstractState {

    @Override
    public Result arraignment(final String activityId, final Status currentStatus) {
        return new Result("0001", "Can't re arraign task since it's in arraign status");
    }

    @Override
    public Result checkPass(final String activityId, final Status currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Pass);
        return new Result("0000", "activity passed");
    }

    @Override
    public Result checkRefuse(final String activityId, final Status currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "activity refused");
    }
}
