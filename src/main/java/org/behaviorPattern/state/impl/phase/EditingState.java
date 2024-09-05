package org.behaviorPattern.state.impl.phase;

import org.behaviorPattern.state.impl.AbstractState;
import org.behaviorPattern.state.impl.ActivityService;
import org.behaviorPattern.state.impl.Result;

/**
 * 活动状态；编辑中
 */
public class EditingState extends AbstractState {
    @Override
    public Result arraignment(final String activityId, final Status currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "Set Activity to check status");
    }

    @Override
    public Result checkPass(final String activityId, final Status currentStatus) {
        return new Result("0001", "Can't set it to pass status since it's in arraign status");
    }

    @Override
    public Result checkRefuse(final String activityId, final Status currentStatus) {
        return new Result("0001", "Can't set it to refuse status since it's in arraign status");
    }
}
