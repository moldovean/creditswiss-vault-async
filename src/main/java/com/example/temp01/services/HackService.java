package com.example.temp01.services;

import com.example.temp01.controllers.QCVault;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HackService {

    private final WebClient.Builder builder;
    private WebClient webClient;
    // https://qcvault.herokuapp.com/

    public HackService(WebClient.Builder builder) {
        this.builder = builder;

        this.webClient = builder
                .baseUrl("https://qcvault.herokuapp.com/unlock_safe")
                .build();
    }

    public Mono<String> hack( int first, int second, int thrid) {
        QCVault data = new QCVault(first, second, thrid);
        Mono<QCVault> just = Mono.just( data);
        Mono<String> response = webClient.post()
                .body(BodyInserters.fromProducer(just, QCVault.class))
                .retrieve()
                .bodyToMono(String.class);
        return response;
    }

    public Flux<String> hackParallel() {
        List<Integer> collect1 = Stream.iterate(0, i -> i + 1)
                .limit(1000).collect(Collectors.toList());


        Flux<String> stringFlux = Flux.fromIterable(collect1)

                .map(i->mapNumber(i))
                .flatMap(ints -> hack(ints.get(0), ints.get(1), ints.get(2)));


        return stringFlux;

    }

    public List<Integer> mapNumber(int number) {
        List<Integer> iaka = new ArrayList<>();
        iaka.add(number/100 % 10);
        iaka.add(number/10 % 10);
        iaka.add(number %10);
        return iaka;
    }



}
