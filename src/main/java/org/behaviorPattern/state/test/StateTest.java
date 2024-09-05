package org.behaviorPattern.state.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.state.impl.AbstractState;
import org.behaviorPattern.state.impl.ActivityService;
import org.behaviorPattern.state.impl.Result;
import org.behaviorPattern.state.impl.StateHandler;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson2.JSON;

public class StateTest {
    private static final Logger log = LogManager.getLogger();

    @Test
    public void test_editing_to_arraignment() {
        final String activityId = "100001";
        ActivityService.init(activityId, AbstractState.Status.Editing);

        final StateHandler stateHandler = new StateHandler();

        Result result = stateHandler.arraignment(activityId, AbstractState.Status.Editing);

        log.info("Testing result: {}", JSON.toJSONString(result));
        log.info("Activity info: {}, Status: {}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
                JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));

    }

    @Test
    public void test_editing_to_open() {
        final String activityId = "100001";
        ActivityService.init(activityId, AbstractState.Status.Editing);

        final StateHandler stateHandler = new StateHandler();

        Result result = stateHandler.checkPass(activityId, AbstractState.Status.Editing);

        log.info("Testing result: {}", JSON.toJSONString(result));
        log.info("Activity info: {}, Status: {}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
                JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }
}
