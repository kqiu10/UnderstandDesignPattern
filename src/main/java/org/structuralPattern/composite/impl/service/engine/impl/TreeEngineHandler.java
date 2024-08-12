package org.structuralPattern.composite.impl.service.engine.impl;

import java.util.Map;

import org.structuralPattern.composite.impl.model.EngineResult;
import org.structuralPattern.composite.impl.model.SearchTree;
import org.structuralPattern.composite.impl.model.TreeNode;
import org.structuralPattern.composite.impl.service.engine.EngineBase;

public class TreeEngineHandler extends EngineBase {
    @Override
    public EngineResult process(final long treeId, final String userId, final SearchTree searchTree,
            final Map<String, String> decisionMatter) {
        TreeNode treeNode = engineDecisionMaker(searchTree, treeId, userId, decisionMatter);

        return new EngineResult(userId, treeId, treeNode.getNodeId(), treeNode.getNodeValue());
    }
}
