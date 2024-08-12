package org.structuralPattern.adapter.impl;

import java.util.Locale;
import java.util.Map;

import com.alibaba.fastjson2.JSON;

public class Adapter {

    private Adapter() {};

    public static CompatibleClass transfer(String strJson, Map<String, String> link) throws Exception {
        return transfer(JSON.parseObject(strJson, Map.class), link);
    }

    /**
     * Convert map of the test class into the map of the compatible class.
     * @param obj map of the test class
     * @param link the key names mapping between test and compatible classes
     * @return the map of the compatible class.
     */
    private static CompatibleClass transfer(Map obj, Map<String, String> link) throws Exception {
        final CompatibleClass compatibleClass = new CompatibleClass();
        for (Map.Entry<String, String> entry : link.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            Object valFromTestClass = obj.get(val);
            CompatibleClass.class.getMethod("set" + key.substring(0, 1).toUpperCase(Locale.ROOT) + key.substring(1), String.class).invoke(compatibleClass, valFromTestClass.toString());
        }
        return compatibleClass;
    }
}
