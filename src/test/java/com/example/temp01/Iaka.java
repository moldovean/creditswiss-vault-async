package com.example.temp01;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class Iaka {

    //https://qcvault.herokuapp.com/unlock_safe
    // {first: 1, second: 0, third: 0}

    @Bean
    public WebClient.Builder wb() {
        return WebClient.builder();
    }

    public static void main(String[] args) {
        System.out.println("adrian@vrabie.net");
    }
}
