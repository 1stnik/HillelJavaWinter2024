package com.hillel.lesson_10.charCount.service;


import com.hillel.lesson_10.charCount.Letter;
import java.util.List;
import java.util.Map;

public interface CountService {

    String normalizeText(String text);

    Map<String, Integer> createDictionary(String text);

    List<Letter> convertMapToList(Map<String, Integer> dictionary, String text);
}
