package org.behaviorPattern.state.impl;

public class Result {
    private String code;
    private String info;

    public Result(final String code, final String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(final String info) {
        this.info = info;
    }
}
