package org.behaviorPattern.state.impl;

import java.util.HashMap;
import java.util.Map;

import org.behaviorPattern.state.impl.phase.CheckState;
import org.behaviorPattern.state.impl.phase.EditingState;
import org.behaviorPattern.state.impl.phase.PassState;
import org.behaviorPattern.state.impl.phase.RefuseState;

public class StateHandler {

    private Map<AbstractState.Status, AbstractState> stateMap = new HashMap<>();

    public StateHandler() {
        stateMap.put(AbstractState.Status.Check, new CheckState());
        stateMap.put(AbstractState.Status.Pass, new PassState());
        stateMap.put(AbstractState.Status.Refuse, new RefuseState());
        stateMap.put(AbstractState.Status.Editing, new EditingState());
    }

    public Result arraignment(String activityId, AbstractState.Status currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public Result checkPass(String activityId, AbstractState.Status currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public Result checkRefuse(String activityId, AbstractState.Status currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

}
