package com.hillel.lesson_06.task;

public class Number {
    /*
       Найти число, состоящее только из различных цифр
     */
    public static void main(String[] args) {

        String value = "123456789";

        boolean flag = true;
        for (int i = 0; i < value.length(); i++){
            char c = value.charAt(i);
            if (value.indexOf(c) != value.lastIndexOf(c)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
