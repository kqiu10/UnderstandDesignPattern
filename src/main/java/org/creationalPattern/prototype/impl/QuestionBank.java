package org.creationalPattern.prototype.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.creationalPattern.prototype.impl.question.AbstractQuestion;
import org.creationalPattern.prototype.impl.question.AnswerQuestion;
import org.creationalPattern.prototype.impl.question.ChoiceQuestion;

public class QuestionBank implements Cloneable {

    private String number;
    private String candidate;

    private ArrayList<AnswerQuestion> answerQuestions = new ArrayList<>();
    private ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<>();

    public QuestionBank append(AbstractQuestion question) {
        if (question instanceof AnswerQuestion) {
            answerQuestions.add((AnswerQuestion) question);
        } else if (question instanceof ChoiceQuestion) {
            choiceQuestions.add((ChoiceQuestion) question);
        } else {
            throw new UnsupportedOperationException("Fail in appending questions, question type doesn't match");
        }
        return this;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        QuestionBank questionBack = (QuestionBank) super.clone();
        questionBack.choiceQuestions = (ArrayList<ChoiceQuestion>) choiceQuestions.clone();
        questionBack.answerQuestions = (ArrayList<AnswerQuestion>) answerQuestions.clone();

        Collections.shuffle(questionBack.choiceQuestions);
        Collections.shuffle(questionBack.answerQuestions);

        for (ChoiceQuestion question : choiceQuestions) {
            question.shuffleOptions();
        }

        return questionBack;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public void setCandidate(final String candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "一、选择题" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestions.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestions.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestions.get(idx).getOptions();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");;
            }
            detail.append("答案：").append(choiceQuestions.get(idx).getAnswer()).append("\r\n\n");
        }

        detail.append("二、问答题" + "\r\n\n");

        for (int idx = 0; idx < answerQuestions.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestions.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestions.get(idx).getAnswer()).append("\r\n\n");
        }

        return detail.toString();
    }
}
