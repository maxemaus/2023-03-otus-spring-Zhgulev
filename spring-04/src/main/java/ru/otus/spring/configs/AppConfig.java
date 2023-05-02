package ru.otus.spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.services.IOServiceStreams;

@Configuration
public class AppConfig {

    @Bean
    public IOServiceStreams ioService() {
        return new IOServiceStreams(System.out, System.in);
    }
}
