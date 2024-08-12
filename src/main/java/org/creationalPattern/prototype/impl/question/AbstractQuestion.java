package org.creationalPattern.prototype.impl.question;

public class AbstractQuestion {

    protected String name;
    protected String answer;

    public AbstractQuestion(final String name, final String answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }


}
