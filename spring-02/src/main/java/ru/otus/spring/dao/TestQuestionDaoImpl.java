package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestQuestionDaoImpl implements TestQuestionDao {

    private final String repository;

    public TestQuestionDaoImpl(@Value("${tasks.path}") String repository) {
        this.repository = repository;
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
