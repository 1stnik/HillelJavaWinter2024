package com.hillel.lesson_19.ex;

public class Ex2 {
    private static void m(int x) {
        System.out.println(x);
        System.out.println("INT VERSION");
    }

    private static void m(char x) {
        System.out.println(x);
        System.out.println("CHAR VERSION");
    }

    private static void m(Integer x) {
        System.out.println(x);
        System.out.println("INTEGER VERSION");
    }

    public static void main(String[] args) {
//          int i = '5';
        char i = '5';
        m(i); // 53
        m('5');

        Integer a= 5;
        m(a);
        m(5);
    }
}
