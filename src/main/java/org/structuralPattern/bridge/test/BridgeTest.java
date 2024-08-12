package org.structuralPattern.bridge.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.structuralPattern.bridge.impl.channel.AliPay;
import org.structuralPattern.bridge.impl.channel.AbstractPay;
import org.structuralPattern.bridge.impl.channel.WechatPay;
import org.structuralPattern.bridge.impl.mode.PayCypher;
import org.structuralPattern.bridge.impl.mode.PayFaceMode;

public class BridgeTest {

    @Test
    public void test_pay_methods() {
        AbstractPay wechatPay = new WechatPay(new PayCypher());
        wechatPay.transfer("10001", "1000000010", new BigDecimal(100L));
        AbstractPay aliPay = new AliPay(new PayFaceMode());
        aliPay.transfer("10002", "100000000011", new BigDecimal(400L));
    }
}
