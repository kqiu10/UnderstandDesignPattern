package org.behaviorPattern.iterator.test;

import java.util.Random;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.iterator.impl.Employee;
import org.behaviorPattern.iterator.impl.GroupStructure;
import org.behaviorPattern.iterator.impl.Link;
import org.behaviorPattern.iterator.impl.lang.Iterator;
import org.junit.jupiter.api.Test;

public class IteratorTest {
    private static final Random rnd = new Random();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Logger log = LogManager.getLogger();

    @Test
    public void test_find_correct_link() {
        GroupStructure groupStructure = new GroupStructure("1", "Org");
        groupStructure.add(new Employee("2", getRandomLetters(), "Department Two"));
        groupStructure.add(new Employee("3", getRandomLetters(), "Department Two"));
        groupStructure.add(new Employee("4", getRandomLetters(), "Department Third"));
        groupStructure.add(new Employee("5", getRandomLetters(), "Department Third"));
        groupStructure.add(new Employee("6", getRandomLetters(), "Department Forth"));
        groupStructure.add(new Employee("7", getRandomLetters(), "Department Forth"));
        groupStructure.add(new Employee("8", getRandomLetters(), "Department Forth"));

        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));

        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));

        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            log.info("{} Employee ID：{} Name：{}", employee.getDesc(), employee.getuId(), employee.getName());
        }
    }

    private String getRandomLetters() {
        return rnd.ints(5, 0, ALPHABET.length()).mapToObj(i -> String.valueOf(ALPHABET.charAt(i))).collect(Collectors.joining());
    }
}
