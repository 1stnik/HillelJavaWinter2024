package com.hillel.lesson_10.CharC;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

    public static void main(String[] args) {
        HashMap<String, Integer> result = new HashMap<>();

        String[] strTest = Text.getText().toLowerCase().split("");

        for (String s : strTest){
            result.put(s, result.getOrDefault(s, 0) + 1);
        }

        System.out.println(result);
    }


}
