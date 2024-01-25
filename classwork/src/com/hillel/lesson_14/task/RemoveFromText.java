package com.hillel.lesson_14.task;


import com.hillel.lesson_06.absrt.Teacher;
import java.util.Arrays;

// Из текста удалить все слова заданной длины, начинающиеся c заданой буквы.
public class RemoveFromText {

    private final static String TEXT = "Скажите зачем эта маленькая княгиня сказал знязь Василий " +
            "зтихо Анне Павловне почему он особенно умного Мы зосле поговорим сказала Анна Павловна" +
            " улыбаясь";

    public static void main(String[] args) {
        String l = "с";
        Arrays.stream(TEXT.split(" ")).map(String::toLowerCase).filter(w -> !w.startsWith(l) && w.length() != 6).forEach(System.out::println);
    }
}
