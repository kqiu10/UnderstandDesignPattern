package org.structuralPattern.composite.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.structuralPattern.composite.impl.model.EngineResult;
import org.structuralPattern.composite.impl.model.NodeRule;
import org.structuralPattern.composite.impl.model.SearchTree;
import org.structuralPattern.composite.impl.model.TreeNode;
import org.structuralPattern.composite.impl.service.engine.IEngine;
import org.structuralPattern.composite.impl.service.engine.impl.TreeEngineHandler;

import com.alibaba.fastjson2.JSON;

public class CompositeTest {
    private static final Logger log = LogManager.getLogger();


    private SearchTree tree;

    @BeforeEach
    public void init() {
        // Rule 1
        final NodeRule rule_1 = new NodeRule();
        rule_1.setRuleDesc("用户性别[男/女]");
        rule_1.setRuleKey("userGender");


        // Rule 2
        final NodeRule rule_2 = new NodeRule();
        rule_2.setRuleDesc("用户年龄");
        rule_2.setRuleKey("userAge");

        // Node 1
        TreeNode rootNode = new TreeNode();
        rootNode.setTreeId(10001L);
        rootNode.setNodeId(1L);
        rootNode.setNodeValue(null);
        rootNode.setRule(rule_1);

        // Node 11
        TreeNode treeNode_11 = new TreeNode();
        treeNode_11.setTreeId(10001L);
        treeNode_11.setNodeId(11L);
        treeNode_11.setNodeValue(null);
        treeNode_11.setRule(rule_2);
        treeNode_11.setRuleLimitValue("man");
        treeNode_11.setRuleLimitType(1);

        // Node 12
        TreeNode treeNode_12 = new TreeNode();
        treeNode_12.setTreeId(10001L);
        treeNode_12.setNodeId(12L);
        treeNode_12.setNodeValue(null);
        treeNode_12.setRule(rule_2);
        treeNode_12.setRuleLimitValue("woman");
        treeNode_12.setRuleLimitType(1);


        // Node 111
        TreeNode treeNode_111 = new TreeNode();
        treeNode_111.setTreeId(10001L);
        treeNode_111.setNodeId(111L);
        treeNode_111.setNodeValue("果实A");
        treeNode_111.setRuleLimitValue("25");
        treeNode_111.setRuleLimitType(3);

        // Node 112
        TreeNode treeNode_112 = new TreeNode();
        treeNode_112.setTreeId(10001L);
        treeNode_112.setNodeId(112L);
        treeNode_112.setNodeValue("果实B");
        treeNode_112.setRuleLimitValue("25");
        treeNode_112.setRuleLimitType(5);

        // Node 121
        TreeNode treeNode_121 = new TreeNode();
        treeNode_121.setTreeId(10001L);
        treeNode_121.setNodeId(121L);
        treeNode_121.setNodeValue("果实C");
        treeNode_121.setRuleLimitValue("25");
        treeNode_121.setRuleLimitType(3);

        // Node 122
        TreeNode treeNode_122 = new TreeNode();
        treeNode_122.setTreeId(10001L);
        treeNode_122.setNodeId(122L);
        treeNode_122.setNodeValue("果实D");
        treeNode_122.setRuleLimitValue("25");
        treeNode_122.setRuleLimitType(5);

        // Rote
        rootNode.setTreeId(10001L);

        // Append child nodes
        treeNode_12.addChildNodes(treeNode_121);
        treeNode_12.addChildNodes(treeNode_122);
        treeNode_11.addChildNodes(treeNode_111);
        treeNode_11.addChildNodes(treeNode_112);
        rootNode.addChildNodes(treeNode_12);
        rootNode.addChildNodes(treeNode_11);

        Map<Long, TreeNode> treeNodeMap = new HashMap<>();
        treeNodeMap.put(1L, rootNode);
        treeNodeMap.put(11L, treeNode_11);
        treeNodeMap.put(12L, treeNode_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);

        tree = new SearchTree(rootNode, treeNodeMap);
    }

    @Test
    public void test_tree() {
        log.info("决策树组合结构信息：\r\n" + JSON.toJSONString(tree));

        IEngine treeEngineHandle = new TreeEngineHandler();

        /**
         * 测试数据
         * 果实A：gender=man、age=22
         * 果实B：gender=man、age=29
         * 果实C：gender=woman、age=22
         * 果实D：gender=woman、age=29
         */
        Map<String, String> decisionMatter1 = new HashMap<>();
        decisionMatter1.put("gender", "man");
        decisionMatter1.put("age", "29");
        Map<String, String> decisionMatter2 = new HashMap<>();
        decisionMatter2.put("gender", "woman");
        decisionMatter2.put("age", "29");
        Map<String, String> decisionMatter3 = new HashMap<>();
        decisionMatter3.put("gender", "man");
        decisionMatter3.put("age", "20");
        Map<String, String> decisionMatter4 = new HashMap<>();
        decisionMatter4.put("gender", "woman");
        decisionMatter4.put("age", "20");

        List<Map<String, String>> cases = new ArrayList<>();
//        cases.add(decisionMatter1);
        cases.add(decisionMatter2);
        cases.add(decisionMatter3);
        cases.add(decisionMatter4);

        for (Map<String, String> decisionMatter: cases) {
            EngineResult result = treeEngineHandle.process(10001L, "Oli09pLkdjh", tree, decisionMatter);
            log.info("测试结果：{}", JSON.toJSONString(result));

        }



    }
}
