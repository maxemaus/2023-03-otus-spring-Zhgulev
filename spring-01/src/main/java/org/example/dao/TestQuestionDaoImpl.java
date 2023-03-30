package org.example.dao;

public class TestQuestionDaoImpl implements TestQuestionDao {

    private final String repository;

    public TestQuestionDaoImpl(String repository) {
        this.repository = repository;
    }

    public String getRepository() {
        return repository;
    }
}
