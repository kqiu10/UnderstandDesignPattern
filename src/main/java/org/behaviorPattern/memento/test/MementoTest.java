package org.behaviorPattern.memento.test;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.memento.impl.Admin;
import org.behaviorPattern.memento.impl.ConfigFile;
import org.behaviorPattern.memento.impl.ConfigOriginator;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson2.JSON;

public class MementoTest {

    private static final Logger log = LogManager.getLogger();

    @Test
    public void test__return_correct_config() {
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();
        final ConfigFile file1 = new ConfigFile(1, "first revision", new Date(), "admin");
        final ConfigFile file2 = new ConfigFile(2, "second revision", new Date(), "admin");
        final ConfigFile file3 = new ConfigFile(3, "third revision", new Date(), "admin");

        configOriginator.setConfigFile(file1);
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(file2);
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(file3);
        admin.append(configOriginator.saveMemento());

        configOriginator.getMemento(admin.undo());
        log.info("Undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        configOriginator.getMemento(admin.undo());
        log.info("Undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        configOriginator.getMemento(admin.redo());
        log.info("Redo {}", JSON.toJSONString(configOriginator.getConfigFile()));

        configOriginator.getMemento(admin.get(3));
        log.info("Get info of specific version set {}", JSON.toJSONString(configOriginator.getConfigFile()));
    }
}
