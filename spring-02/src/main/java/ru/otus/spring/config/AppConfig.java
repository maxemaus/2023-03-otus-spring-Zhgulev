package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.services.IOServiceStreams;

@PropertySource("/application.properties")
@Configuration
public class AppConfig {

    @Bean
    public IOServiceStreams ioService() {
        return new IOServiceStreams(System.out, System.in);
    }
}
