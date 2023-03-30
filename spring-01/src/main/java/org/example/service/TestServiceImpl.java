package org.example.service;

import org.example.dao.TestDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestServiceImpl implements TestService{

    private final TestDaoImpl testDao;

    public TestServiceImpl(TestDaoImpl testDaoImpl) {
        this.testDao = testDaoImpl;
    }

    public TestDaoImpl getTestDao() {
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
