package ru.otus.spring.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.spring.services.TestQuestionServiceImpl;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final TestQuestionServiceImpl testQuestionService;

    public ApplicationRunner(TestQuestionServiceImpl testQuestionService) {
        this.testQuestionService = testQuestionService;
    }

    @Override
    public void run(String... args) throws Exception {
        testQuestionService.displayProcessListTest();
    }
}
