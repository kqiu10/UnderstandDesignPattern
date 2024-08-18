package org.behaviorPattern.memento.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Admin {
    private int cursorIdx = -1;

    private List<ConfigMemento> mementoList = new ArrayList<>();
    private Map<Integer, ConfigMemento> mementoMap = new ConcurrentHashMap<>();

    public void append(ConfigMemento configMemento) {
        mementoList.add(configMemento);
        mementoMap.put(configMemento.getConfigFile().getVersionNo(), configMemento);
        cursorIdx++;
    }

    public ConfigMemento undo() {
        if (cursorIdx == -1) {
            throw new IllegalStateException("Find zero available config file");
        }
        cursorIdx--;
        return mementoList.get(cursorIdx);
    }

    public ConfigMemento redo() {
        if (cursorIdx == mementoList.size()) {
            return mementoList.get(cursorIdx);
        }
        cursorIdx++;
        return mementoList.get(cursorIdx);
    }

    public ConfigMemento get(int versionNo) {
        return mementoMap.get(versionNo);
    }

}
