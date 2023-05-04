package ru.otus.spring.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.configs.AppProps;
import ru.otus.spring.dao.TestQuestionDaoImpl;

import java.util.List;

@Service
public class TestQuestionServiceImpl implements TestQuestionService {

    private static int counterLines;

    private final MessageSource messageSource;

    private final TestQuestionDaoImpl testDao;

    private final IOService ioService;

    private final AppProps props;

    public TestQuestionServiceImpl(MessageSource messageSource, TestQuestionDaoImpl testDao, IOService ioService,
                                   AppProps props) {
        this.messageSource = messageSource;
        this.testDao = testDao;
        this.ioService = ioService;
        this.props = props;
    }

    @Override
    public void displayProcessListTest() {
        ioService.outputString(messageSource.getMessage("getName", null, props.getLocale()));
        String name = ioService.inputLine();
        int pointsReceived = 0;
        List<String> questions = testDao.getListByQuestions();
        for (int i = 0; i <= questions.size(); i++) {
            printQuestionsAndAnswers(counterLines);
            ioService.outputString(messageSource.getMessage("answer", null, props.getLocale()));
            if (ioService.inputLine().equals(questions.get(counterLines - 1))) {
                pointsReceived += 1;
            }
            ioService.outputString(String.format(messageSource.getMessage("result", null, props.getLocale()),
                                    name, pointsReceived));
            if (counterLines == questions.size() - 1) {
                break;
            }
        }
        ioService.outputString(String.format(messageSource.getMessage("overalResult", null, props.getLocale()),
                                name, pointsReceived));
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
