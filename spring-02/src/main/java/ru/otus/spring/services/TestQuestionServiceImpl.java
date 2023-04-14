package ru.otus.spring.services;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.TestQuestionDaoImpl;

import java.util.List;

@Service
public class TestQuestionServiceImpl implements TestQuestionService {

    private static int counterLines;

    private final TestQuestionDaoImpl testDao;

    private final IOService ioService;

    public TestQuestionServiceImpl(TestQuestionDaoImpl testDao, IOService ioService) {
        this.testDao = testDao;
        this.ioService = ioService;
    }

    @Override
    public void displayProcessListTest() {
        ioService.outputString("Enter your name");
        String name = ioService.inputLine();
        int pointsReceived = 0;
        List<String> questions = testDao.getListByQuestions();
        for (int i = 0; i <= questions.size(); i++) {
            printQuestionsAndAnswers(counterLines);
            ioService.outputString("Enter your Answer");
            if (ioService.inputLine().equals(questions.get(counterLines - 1))) {
                pointsReceived += 1;
            }
            ioService.outputString(name + ", your result " + pointsReceived + " points.");
            if (counterLines == questions.size() - 1) {
                break;
            }
        }
        ioService.outputString("Your overall result " + name + " " + pointsReceived + " points.");
    }

    private void printQuestionsAndAnswers(int counter) {
        for (int i = 0; i < 5; i++) {
            ioService.outputString(testDao.getListByQuestions().get(counterLines));
            counterLines++;
            if (i == 4) {
                counterLines += 1;
            }
        }
    }
}
