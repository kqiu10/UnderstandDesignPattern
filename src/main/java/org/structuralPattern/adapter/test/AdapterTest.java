package org.structuralPattern.adapter.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.structuralPattern.adapter.impl.Adapter;
import org.structuralPattern.adapter.impl.CompatibleClass;
import org.structuralPattern.adapter.impl.TestClass;

import com.alibaba.fastjson2.JSON;

public class AdapterTest {

    @Test
    public void test_Adapter() throws Exception {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");

        final TestClass testClass = new TestClass();

        testClass.setAddress("905 Dexter Ave N");
        testClass.setAccountDate(parse);
        testClass.setNumber("10001");
        testClass.setDesc("Bank account");

        HashMap<String, String> adapterMap = new HashMap<>();
        adapterMap.put("userId", "number");
        adapterMap.put("bizId", "number");
        adapterMap.put("bizTime", "accountDate");
        adapterMap.put("desc", "desc");

        final CompatibleClass transferred = Adapter.transfer(testClass.toString(), adapterMap);
        System.out.println("before adapter" + testClass);
        System.out.println("after adapter" + JSON.toJSONString(transferred));
    }
}
