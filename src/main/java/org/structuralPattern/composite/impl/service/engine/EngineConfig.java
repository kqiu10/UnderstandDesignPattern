package org.structuralPattern.composite.impl.service.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.structuralPattern.composite.impl.service.logic.LogicFilter;
import org.structuralPattern.composite.impl.service.logic.impl.UserAgeFilter;
import org.structuralPattern.composite.impl.service.logic.impl.UserGenderFilter;

public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }

}
