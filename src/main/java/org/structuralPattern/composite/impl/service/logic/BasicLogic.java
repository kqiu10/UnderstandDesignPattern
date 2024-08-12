package org.structuralPattern.composite.impl.service.logic;

import org.structuralPattern.composite.impl.model.TreeNode;

public abstract class BasicLogic implements LogicFilter {
    @Override
    public long filter(final String matterValue, TreeNode node) {
        if (!node.getChildNodes().isEmpty()) {
            for (TreeNode child : node.getChildNodes()) {
                if (decisionLogic(matterValue, child)) {
                    return child.getNodeId();
                }
            }
        }
        return 0L;
    }

    private boolean decisionLogic(String matterValue, TreeNode node) {
        switch (node.getRuleLimitType()) {
            case 1:
                return matterValue.equals(node.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(node.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(node.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) <= Double.parseDouble(node.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) >= Double.parseDouble(node.getRuleLimitValue());
            default:
                return false;
        }
    }
}
