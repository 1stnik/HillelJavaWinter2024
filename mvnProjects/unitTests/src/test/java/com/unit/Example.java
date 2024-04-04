package com.unit;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Example {
    @BeforeEach
    void setUpOne() {
        System.out.println("1");
    }

    @BeforeEach
    void setUpTwo() {
        System.out.println("2");
    }

    @Test
    void shouldDoTest() {
        List.of(new Object(), "1", 1, new String())
            .stream()
            .forEach(o -> System.out.println(o.toString()));

    }
}
