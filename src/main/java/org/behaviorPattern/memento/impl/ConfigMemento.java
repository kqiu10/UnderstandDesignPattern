package org.behaviorPattern.memento.impl;

public class ConfigMemento {

    private ConfigFile configFile;

    public ConfigMemento(final ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(final ConfigFile configFile) {
        this.configFile = configFile;
    }
}
