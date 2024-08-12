package org.structuralPattern.bridge.impl.channel;

import java.math.BigDecimal;

import org.structuralPattern.bridge.impl.mode.IPayMode;

public class WechatAbstractPay extends AbstractPay {

    public WechatAbstractPay(final IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(final String uid, final String tradeId, final BigDecimal amount) {
        log.info("Pay by wechat。uId：{} tradeId：{} amount：{}", uid, tradeId, amount);
        payMode.security(uid);
        return "0000";
    }
}
