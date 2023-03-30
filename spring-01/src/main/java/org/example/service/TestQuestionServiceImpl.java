package org.example.service;

import org.example.dao.TestQuestionDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestQuestionServiceImpl implements TestQuestionService {

    private final TestQuestionDaoImpl testDao;

    public TestQuestionServiceImpl(TestQuestionDaoImpl testDaoImpl) {
        this.testDao = testDaoImpl;
    }

    public TestQuestionDaoImpl getTestDao() {
        return testDao;
    }

    @Override
    public void displayListTest(String path) {
        InputStream in = getClass().getResourceAsStream(testDao.getRepository());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(System.out::println);
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
