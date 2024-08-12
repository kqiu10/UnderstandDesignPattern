package org.structuralPattern.composite.impl.service.logic.impl;

import java.util.Map;

import org.structuralPattern.composite.impl.service.logic.BasicLogic;

public class UserAgeFilter extends BasicLogic {
    @Override
    public String getMatterValue(final long treeId, final String userId, final Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
