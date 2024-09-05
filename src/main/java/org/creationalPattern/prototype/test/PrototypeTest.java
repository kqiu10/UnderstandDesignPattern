package org.creationalPattern.prototype.test;

import org.creationalPattern.prototype.impl.QuestionBankGenerator;
import org.junit.jupiter.api.Test;

public class PrototypeTest {

    @Test
    public void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankGenerator questionBankController = new QuestionBankGenerator();
        System.out.println(questionBankController.createPaper("Flower", "1000001921032"));
        System.out.println(questionBankController.createPaper("Bean", "1000001921051"));
        System.out.println(questionBankController.createPaper("Gold", "1000001921987"));
    }
}
