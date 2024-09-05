package org.behaviorPattern.state.impl.phase;

import org.behaviorPattern.state.impl.AbstractState;
import org.behaviorPattern.state.impl.Result;

public class RefuseState extends AbstractState {
    @Override
    public Result arraignment(final String activityId, final Status currentStatus) {
        return new Result("0001", "Can't re arraign task since it's in refused status");
    }

    @Override
    public Result checkPass(final String activityId, final Status currentStatus) {
        return new Result("0001", "Can't re pass task since it's in refused status");
    }

    @Override
    public Result checkRefuse(final String activityId, final Status currentStatus) {
        return new Result("0001", "Can't re refuse task since it's in refused status");
    }
}
