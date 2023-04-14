package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.config.AppConfig;
import ru.otus.spring.services.TestQuestionService;
import ru.otus.spring.services.TestQuestionServiceImpl;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestQuestionService testQuestionService = context.getBean(TestQuestionServiceImpl.class);
        testQuestionService.displayProcessListTest();
    }
}