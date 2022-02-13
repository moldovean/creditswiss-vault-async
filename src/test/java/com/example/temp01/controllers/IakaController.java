package com.example.temp01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class IakaController {


    private final WebClient.Builder builder;

    public IakaController(WebClient.Builder builder) {
        this.builder = builder;
    }

    @GetMapping("hello")
    public Mono<String> hello() {
        WebClient client = builder.baseUrl("https://qcvault.herokuapp.com/unlock_safe")
                .build();
        Mono<QCVault> just = Mono.just(new QCVault(1, 1, 1));
        Mono<String> response = client.post()
                .body(BodyInserters.fromProducer(just, QCVault.class))
                .retrieve()
                .bodyToMono(String.class);
        return response;
    }

    @GetMapping("/hi")
    public Mono<String> hi() {
        return Mono.just("hi");
    }

}
