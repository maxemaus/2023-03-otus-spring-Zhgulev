package ru.otus.spring.model;

import lombok.Data;

import java.util.List;

@Data
public class TestQuestion {

    private final String question;

    private List<String> answer;

    public TestQuestion(String question) {
        this.question = question;
    }
}
