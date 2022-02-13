package com.example.temp01.controllers;

import com.example.temp01.services.HackService;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class IakaController {


    private final WebClient.Builder builder;
    private final HackService hackService;

    public IakaController(WebClient.Builder builder, HackService hackService) {
        this.builder = builder;
        this.hackService = hackService;
    }

    @GetMapping(value = "/hello")
    public Flux<String> hello() {
        WebClient client = builder.baseUrl("https://qcvault.herokuapp.com/unlock_safe")
                .build();
        Flux<String> response = hackService.hackParallel();
        return response;
    }



    @GetMapping("/hi")
    public Mono<String> hi() {
        return Mono.just("hi");
    }

}
