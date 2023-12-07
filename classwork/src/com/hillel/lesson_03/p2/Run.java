package com.hillel.lesson_03.p2;


import com.hillel.lesson_03.p1.Clazz1;

public class Run {
    public static void main(String[] args) {
        Clazz1 c1 = new Clazz1();
        Clazz2 c2 = new Clazz2();

        c1.m4(); // public

        c2.m2(); // default
        c2.m3(); // protect
        c2.m4(); // public



        int i = 4563;

        char ch = (char) i;

        System.out.println(ch);

        short s = (short) ch;

        System.out.println(ch);
        System.out.println(s);

    }
}
