package org.example.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestQuestionDaoImpl implements TestQuestionDao {

    private final String repository;

    public TestQuestionDaoImpl(String repository) {
        this.repository = repository;
    }

    public String getRepository() {
        return repository;
    }

    @Override
    public List<String> getListByQuestions() {
        List<String> list = new ArrayList<>();
        InputStream in = getClass().getResourceAsStream(repository);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(list::add);
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
