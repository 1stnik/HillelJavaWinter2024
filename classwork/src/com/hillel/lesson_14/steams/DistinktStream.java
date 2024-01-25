package com.hillel.lesson_14.steams;

import java.util.List;

public class DistinktStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,1,2,1,2,1,2);
        ints.stream().distinct().forEach(i -> System.out.print(i + " "));

    }
}
