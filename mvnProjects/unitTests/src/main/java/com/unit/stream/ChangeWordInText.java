package com.unit.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeWordInText {

    public String changeWord(String text, String word, Long length ){
        return Arrays.stream(text.split(" ")).map(s -> s.length() == length ? word : s).collect(Collectors.joining(" "));
    }

}
