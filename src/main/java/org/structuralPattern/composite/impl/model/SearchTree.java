package org.structuralPattern.composite.impl.model;

import java.util.Map;

public class SearchTree {
    private TreeNode root;
    private Map<Long, TreeNode> treeMap;

    public SearchTree(final TreeNode root, final Map<Long, TreeNode> treeMap) {
        this.root = root;
        this.treeMap = treeMap;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(final TreeNode root) {
        this.root = root;
    }

    public Map<Long, TreeNode> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(final Map<Long, TreeNode> treeMap) {
        this.treeMap = treeMap;
    }
}
