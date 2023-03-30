package org.example.dao;

public class TestDaoImpl implements TestDao{

    private final String repository;

    public TestDaoImpl(String repository) {
        this.repository = repository;
    }

    public String getRepository() {
        return repository;
    }
}
