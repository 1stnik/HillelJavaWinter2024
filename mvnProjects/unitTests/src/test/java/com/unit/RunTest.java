package com.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunTest {


    @BeforeAll
    static void initClass() {
        System.out.println("---> run before test class");
    }

    @AfterAll
    static void closeClass() {
        System.out.println("---> run after test class");
    }

    @BeforeEach
    void initTest() {
        System.out.println("----> run before test case");
    }

    @AfterEach
    void closeTest() {
        System.out.println("---> run after test case");
    }


    @Test
    void firstTest() {
        System.out.println("----> first test");
    }

    @Test
    void secondTest() {
        System.out.println("-----> second test");
    }


}
