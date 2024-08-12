package org.structuralPattern.composite.impl.service.engine;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.structuralPattern.composite.impl.model.SearchTree;
import org.structuralPattern.composite.impl.model.TreeNode;
import org.structuralPattern.composite.impl.service.logic.LogicFilter;
import org.structuralPattern.composite.impl.model.NodeRule;

public abstract class EngineBase extends EngineConfig implements IEngine {
    private static final Logger log = LogManager.getLogger();

    protected TreeNode engineDecisionMaker(SearchTree searchTree, long treeId, String userId, Map<String, String> decisionMatter) {
        final TreeNode root = searchTree.getRoot();
        final Map<Long, TreeNode> treeMap = searchTree.getTreeMap();

        TreeNode curNode = root;
        while (!curNode.getChildNodes().isEmpty()) {
            final NodeRule rule = curNode.getRule();
            final String ruleKey = rule.getRuleKey();
            final LogicFilter filter = logicFilterMap.get(ruleKey);
            final String matterValue = filter.getMatterValue(treeId, userId, decisionMatter);
            long nextNodeId = filter.filter(matterValue, curNode);
            log.info("Current node info: curNodeId={}, nextNodeId={}, matterValue={}, ruleId={}", curNode.getNodeId(), nextNodeId,
                    matterValue, ruleKey);
            curNode = treeMap.get(nextNodeId);
        }
        return curNode;
    }

}
