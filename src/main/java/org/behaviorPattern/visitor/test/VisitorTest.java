package org.behaviorPattern.visitor.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.visitor.impl.DataView;
import org.behaviorPattern.visitor.impl.visitor.Parent;
import org.behaviorPattern.visitor.impl.visitor.Principal;
import org.junit.jupiter.api.Test;

public class VisitorTest {
    private static final Logger log = LogManager.getLogger();

    @Test
    public void test_visitor_return_right_value() {
        DataView dataView = new DataView();

        log.info("\r\nParent view：");
        dataView.show(new Parent());

        log.info("\r\nPrincipal view：");
        dataView.show(new Principal());
    }
}
