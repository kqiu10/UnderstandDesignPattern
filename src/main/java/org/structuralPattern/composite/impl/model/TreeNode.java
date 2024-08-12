package org.structuralPattern.composite.impl.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private long treeId;
    private long nodeId;
    private String nodeValue;
    private NodeRule rule;
    private String ruleLimitValue;
    private int ruleLimitType;

    public int getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(final int ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(final String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }

    private List<TreeNode> childNodes = new ArrayList<>();

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

    public NodeRule getRule() {
        return rule;
    }

    public void setRule(final NodeRule rule) {
        this.rule = rule;
    }

    public List<TreeNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(final List<TreeNode> childNodes) {
        this.childNodes = childNodes;
    }

    public List<TreeNode> addChildNodes(final TreeNode childNodes) {
        this.childNodes.add(childNodes);
        return this.childNodes;
    }
}
