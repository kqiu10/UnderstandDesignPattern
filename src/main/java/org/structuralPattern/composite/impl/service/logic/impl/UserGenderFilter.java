package org.structuralPattern.composite.impl.service.logic.impl;

import java.util.Map;

import org.structuralPattern.composite.impl.service.logic.BasicLogic;

public class UserGenderFilter extends BasicLogic {
    @Override
    public String getMatterValue(final long treeId, final String userId, final Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
