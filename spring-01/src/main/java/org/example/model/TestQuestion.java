package org.example.model;

import java.util.List;

public class TestQuestion {

    private String question;

    private List<String> answer;

    public TestQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
