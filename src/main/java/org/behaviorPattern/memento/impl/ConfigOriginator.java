package org.behaviorPattern.memento.impl;

public class ConfigOriginator {

    private ConfigFile configFile;

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(final ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento saveMemento() {
        return new ConfigMemento(this.configFile);
    }

    public void getMemento(ConfigMemento configMemento) {
        this.configFile = configMemento.getConfigFile();
    }
}
