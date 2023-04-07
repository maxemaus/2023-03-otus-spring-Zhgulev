package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.dao.TestQuestionDao;
import ru.otus.spring.dao.TestQuestionDaoImpl;
import ru.otus.spring.services.IOServiceStreams;
import ru.otus.spring.services.TestQuestionService;
import ru.otus.spring.services.TestQuestionServiceImpl;

@PropertySource("/application.properties")
@Configuration
public class AppConfig {

    @Bean
    public TestQuestionDao testQuestionDao(@Value("${tasks.path}") String tasksPath) {
        return new TestQuestionDaoImpl(tasksPath);
    }

    @Bean
    public IOServiceStreams ioService() {
        return new IOServiceStreams(System.out, System.in);
    }

    @Bean
    public TestQuestionService testQuestionService(TestQuestionDaoImpl testQuestionDao, IOServiceStreams ioService) {
        return new TestQuestionServiceImpl(testQuestionDao, ioService);
    }
}
