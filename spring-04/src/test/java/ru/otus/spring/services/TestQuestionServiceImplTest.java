package ru.otus.spring.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.dao.TestQuestionDaoImpl;

import java.util.Arrays;
import java.util.List;

@DisplayName("Класс TestQuestionService")
@SpringBootTest
class TestQuestionServiceImplTest {

    @MockBean
    private TestQuestionDaoImpl testDao;

    @MockBean
    private IOService ioService;

    List<String> questions = Arrays.asList("Question 1", "Question 2", "Question 3", "Question 4", "Question 5", "Question 6");

    @Test
    @DisplayName("Вывод по 5 строк")
    public void printQuestionsAndAnswers() {
        Mockito.when(testDao.getListByQuestions()).thenReturn(questions);
    }
}