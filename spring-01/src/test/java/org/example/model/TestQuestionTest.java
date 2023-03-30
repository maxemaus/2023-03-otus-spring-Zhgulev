package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("класс TestQuestion")
class TestQuestionTest {
    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        TestQuestion question = new TestQuestion("How are you?");
        assertEquals("How are you?", question.getQuestion());
    }

}