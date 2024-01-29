package com.hillel.lesson_15.task;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CharCount {
    public static void main(String[] args) {
        System.out.println(new TreeMap<>(calculateGroupBy(StringTest.TEXT_R)));
    }

    private static Map<String, Integer> calculateGroupBy(String text) {
         return Arrays.stream(
                text.replaceAll("\\p{P}", "") // punctuation
                        .replaceAll(" ", "")
                        .toLowerCase().split(""))
                .collect(Collectors.groupingBy(e -> e)).
                         entrySet().stream()
                 .collect(Collectors.toMap(e -> e.getValue().get(0), e -> e.getValue().size()));
    }
}
