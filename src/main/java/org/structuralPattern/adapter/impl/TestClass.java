package org.structuralPattern.adapter.impl;

import java.util.Date;

import com.alibaba.fastjson2.JSON;

public class TestClass {

    private String number;
    private String address;
    private Date accountDate;
    private String desc;

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(final Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
       return JSON.toJSONString(this);
    }
}
