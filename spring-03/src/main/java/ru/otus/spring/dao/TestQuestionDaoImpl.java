package ru.otus.spring.dao;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.configs.AppProps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestQuestionDaoImpl implements TestQuestionDao {

    private final MessageSource messageSource;

    private final AppProps props;

    public TestQuestionDaoImpl(MessageSource messageSource, AppProps props) {
        this.messageSource = messageSource;
        this.props = props;
    }

    @Override
    public List<String> getListByQuestions() {
        List<String> list = new ArrayList<>();
        InputStream in = getClass().getResourceAsStream(props.getQuestions());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        reader.lines().forEach(list::add);
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
