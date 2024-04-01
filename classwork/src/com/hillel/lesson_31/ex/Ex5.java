package com.hillel.lesson_31.ex;

public class Ex5 {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;

        System.out.println(true ? x : 0); // X -> string
        System.out.println(false ? i : x); // 88 -> int <> int
        System.out.println(false ? 0 : x); //
    }
}
