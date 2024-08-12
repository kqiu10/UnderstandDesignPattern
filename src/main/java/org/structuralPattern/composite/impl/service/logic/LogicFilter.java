package org.structuralPattern.composite.impl.service.logic;

import java.util.Map;

import org.structuralPattern.composite.impl.model.TreeNode;

public interface LogicFilter {

    /**
     * Return nodeId if matterValue matches current node's nodeValue.
     */
    long filter(String matterValue, TreeNode node);

    /**
     * Get matterValue
     */
    String getMatterValue(long treeId, String userId, Map<String, String> decisionMatter);
}
