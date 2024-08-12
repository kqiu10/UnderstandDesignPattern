package org.structuralPattern.composite.impl.service.engine;

import java.util.Map;

import org.structuralPattern.composite.impl.model.EngineResult;
import org.structuralPattern.composite.impl.model.SearchTree;

public interface IEngine {

    EngineResult process(final long treeId, final String userId, SearchTree searchTree, final Map<String, String> decisionMatter);
}
