package com.example.temp01.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HackServiceTest {

    @Autowired
    HackService hackService;

    @Test
    public void iaka() {
        List<Integer> integers = hackService.mapNumber(343);
        System.out.println(integers.toString());
        Assertions.assertEquals(3, integers.get(0));
    }

}