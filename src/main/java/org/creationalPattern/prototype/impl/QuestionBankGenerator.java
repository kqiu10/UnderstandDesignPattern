package org.creationalPattern.prototype.impl;

import java.util.HashMap;

import org.creationalPattern.prototype.impl.question.AnswerQuestion;
import org.creationalPattern.prototype.impl.question.ChoiceQuestion;

public class QuestionBankGenerator {

    private QuestionBank questionBank = new QuestionBank();

    public QuestionBankGenerator() {

        questionBank.append(new ChoiceQuestion("JAVA version doesn't include", new HashMap<String, String>() {{
                    put("A", "JAVA2 EE");
                    put("B", "JAVA2 Card");
                    put("C", "JAVA2 ME");
                    put("D", "JAVA2 HE");
                    put("E", "JAVA2 SE");
                }}, "D")).append(new ChoiceQuestion("Choose the correct one in the following options", new HashMap<String, String>() {{
                    put("A", "Cain method must be included in Class");
                    put("B", "Cne class can have many main methods");
                    put("C", "Class name must be the same as file name");
                    put("D", "Don't need {} if there is only one sentence in main method");
                }}, "A")).append(new ChoiceQuestion("Choose B", new HashMap<String, String>() {{
                    put("A", "A");
                    put("B", "B");
                    put("C", "C");
                    put("D", "D");
                }}, "B")).append(new ChoiceQuestion("which identifier is not allowed", new HashMap<String, String>() {{
                    put("A", "STRING");
                    put("B", "x3x;");
                    put("C", "void");
                    put("D", "de$f");
                }}, "C")).append(new ChoiceQuestion("result of (11+3*8)/4%3", new HashMap<String, String>() {{
                    put("A", "31");
                    put("B", "0");
                    put("C", "1");
                    put("D", "2");
                }}, "D")).append(new AnswerQuestion("how many legs does horse have", "four"));
    }

    public String createPaper(String candidate, String number) throws CloneNotSupportedException {
        QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
        questionBankClone.setCandidate(candidate);
        questionBankClone.setNumber(number);
        return questionBankClone.toString();
    }
}