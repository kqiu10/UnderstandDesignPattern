package org.creationalPattern.prototype.impl.question;

public class AnswerQuestion extends AbstractQuestion {

    public AnswerQuestion(final String name, final String answer) {
        super(name, answer);
    }

    @Override
    public String toString() {
        return "AnswerQuestion{" + "name='" + name + '\'' + ", answer='" + answer + '\'' + '}';
    }
}
