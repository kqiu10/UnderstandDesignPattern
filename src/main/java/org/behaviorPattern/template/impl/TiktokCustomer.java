package org.behaviorPattern.template.impl;

import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson2.JSON;

import sun.misc.BASE64Encoder;

public class TiktokCustomer extends AbstractCustomer {
    public TiktokCustomer(final String uId, final String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected Boolean login(final String uid, final String uPwd) {
        log.info("Tiktok customer log with uid {}, uPwd {}", uid, uPwd);
        return true;
    }

    @Override
    protected String createBase64(final String identifier) {
        BASE64Encoder encoder = new BASE64Encoder();
        log.info("Mimic creating Base64 {}", getClass());
        return encoder.encode(JSON.toJSONString(identifier).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    protected String createIdentifier() {
        return String.valueOf(rnd.nextInt(500) + 100);
    }
}
