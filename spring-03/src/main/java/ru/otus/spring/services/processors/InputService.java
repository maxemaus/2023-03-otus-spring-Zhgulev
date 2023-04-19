package ru.otus.spring.services.processors;

public interface InputService {

    String inputString(String task);

    String inputLine();

    String readStringWithPrompt(String prompt);
}
