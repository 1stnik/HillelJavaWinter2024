package com.hillel.java;

import java.time.LocalDateTime;
import org.apache.commons.lang3.RandomStringUtils;


public class Run {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        }
        System.out.println(RandomStringUtils.randomAlphabetic(10));
        System.out.println(RandomStringUtils.randomNumeric(100));
        System.out.println("Hello world " + LocalDateTime.now());
    }
}
