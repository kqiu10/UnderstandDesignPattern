package org.behaviorPattern.template.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.template.impl.AbstractCustomer;
import org.behaviorPattern.template.impl.TiktokCustomer;
import org.behaviorPattern.template.impl.TwitterCustomer;
import org.junit.jupiter.api.Test;

public class TemplateTest {
    private static final Logger log = LogManager.getLogger();


    @Test
    public void test_log_with_Tiktok() {
        final String uId = "10001";
        final String uPwd = "fhuspdk";
        final AbstractCustomer tiktokCustomer = new TiktokCustomer(uId, uPwd);
        final String base64 = tiktokCustomer.generateRandomIdentifier();
        log.info("Base64 is {}", base64);
    }

    @Test
    public void test_log_with_Twitter() {
        final String uId = "10001";
        final String uPwd = "fhuspdk";
        final AbstractCustomer twitterCustomer = new TwitterCustomer(uId, uPwd);
        final String base64 = twitterCustomer.generateRandomIdentifier();
        log.info("Base64 is {}", base64);
    }
}
