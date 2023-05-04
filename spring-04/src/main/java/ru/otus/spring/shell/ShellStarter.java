package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.services.IOService;
import ru.otus.spring.services.TestQuestionService;

@ShellComponent
@RequiredArgsConstructor
public class ShellStarter {

    private final TestQuestionService runner;

    private final IOService ioService;

    private String readyForTest;

    @ShellMethod(value = "ready for testing", key = "ready")
    public void getTestingStart(@ShellOption(defaultValue = "ready")String readyForTest) {
        this.readyForTest = readyForTest;
        ioService.outputString("Для того чтобы начать тестирование введите команду go");
    }

    @ShellMethod(value = "starting the testing process", key = "go")
    @ShellMethodAvailability(value = "isTestingStart")
    public void startTestingProcess() throws Exception {
        runner.displayProcessListTest();
    }

    private Availability isTestingStart() {
        return readyForTest == null? Availability
                .unavailable("Укажите готовы ли вы к началу тестирования") : Availability.available();
    }
}
