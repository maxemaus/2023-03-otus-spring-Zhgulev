package org.example.service;

import org.example.dao.TestQuestionDaoImpl;

public class TestQuestionServiceImpl implements TestQuestionService {

    private final TestQuestionDaoImpl testDao;

    public TestQuestionServiceImpl(TestQuestionDaoImpl testDao) {
        this.testDao = testDao;
    }

    public TestQuestionDaoImpl getTestDao() {
        return testDao;
    }

    @Override
    public void displayListTest() {
        testDao.getListByQuestions().forEach(System.out::println);
    }
}
