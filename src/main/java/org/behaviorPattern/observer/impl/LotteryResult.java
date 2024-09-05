package org.behaviorPattern.observer.impl;

import java.util.Date;

public class LotteryResult {

    private String uId;
    private String msg;
    private Date dateTime;

    public LotteryResult(final String uId, final String msg, final Date dateTime) {
        this.uId = uId;
        this.msg = msg;
        this.dateTime = dateTime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(final String uId) {
        this.uId = uId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(final Date dateTime) {
        this.dateTime = dateTime;
    }
}
