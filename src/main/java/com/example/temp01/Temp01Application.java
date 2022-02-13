package com.example.temp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Temp01Application {

    @Bean
    public WebClient.Builder wb() {
        return WebClient.builder();
    }
    public static void main(String[] args) {
        SpringApplication.run(Temp01Application.class, args);
    }

}
