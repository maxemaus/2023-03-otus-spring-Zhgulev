package org.example;

import org.example.dao.TestDaoImpl;
import org.example.service.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestService service = context.getBean(TestService.class);
        TestDaoImpl testDao = context.getBean(TestDaoImpl.class);
        service.displayListTest(testDao.getRepository());
    }
}