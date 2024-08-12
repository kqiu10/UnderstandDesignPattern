package org.structuralPattern.composite.impl.model;

public class EngineResult {
    private boolean isSuccess;
    private String userId;
    private long treeId;
    private long nodeId;
    private String nodeValue;

    public EngineResult(final boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public EngineResult(final String userId, final long treeId, final long nodeId, final String nodeValue) {
        this.isSuccess = true;
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(final boolean success) {
        isSuccess = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public long getTreeId() {
        return treeId;
    }

    public void setTreeId(final long treeId) {
        this.treeId = treeId;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(final long nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(final String nodeValue) {
        this.nodeValue = nodeValue;
    }
}
