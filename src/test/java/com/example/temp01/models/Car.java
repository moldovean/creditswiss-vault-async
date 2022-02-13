package com.example.temp01.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String name;
    private int value;
}
