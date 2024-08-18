package org.behaviorPattern.memento.impl;

import java.util.Date;

public class ConfigFile {
    private int versionNo;
    private String content;
    private Date dateTime;
    private String operator;

    public ConfigFile(final int versionNo, final String content, final Date dateTime, final String operator) {
        this.versionNo = versionNo;
        this.content = content;
        this.dateTime = dateTime;
        this.operator = operator;
    }

    public int getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(final int versionNo) {
        this.versionNo = versionNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(final Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }
}
