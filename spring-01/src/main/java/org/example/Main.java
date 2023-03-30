package org.example;

import org.example.dao.TestQuestionDaoImpl;
import org.example.service.TestQuestionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestQuestionService service = context.getBean(TestQuestionService.class);
        TestQuestionDaoImpl testDao = context.getBean(TestQuestionDaoImpl.class);
        service.displayListTest(testDao.getRepository());
    }
}