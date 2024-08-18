package org.behaviorPattern.chainOfResponsibility.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.behaviorPattern.chainOfResponsibility.impl.LevelOneChainNode;
import org.behaviorPattern.chainOfResponsibility.impl.LevelThreeChainNode;
import org.behaviorPattern.chainOfResponsibility.impl.LevelTwoChainNode;
import org.behaviorPattern.chainOfResponsibility.impl.chainNode.AbstractChainNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ChainOfResponsibilityTest {

    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @ParameterizedTest
    @MethodSource("dateProvider")
    public void test_get_correct_authInfo(Date inputDate) throws ParseException {
        AbstractChainNode root = new LevelOneChainNode("10001", "L6");
        AbstractChainNode NodeTwo = new LevelTwoChainNode("10002", "L7");
        AbstractChainNode NodeThree = new LevelThreeChainNode("10003", "L8");
        root.setNext(NodeTwo);
        NodeTwo.setNext(NodeThree);
        root.doAuth("0001", "Jack Ma", inputDate).getAuthInfo();
    }

    static Stream<Date> dateProvider() throws ParseException {
        return Stream.of(
                format.parse("01-05-2022"),
                format.parse("10-10-2024"),
                format.parse("20-12-2024"));
    }

}
