package com.hillel.lesson_05.animal;

public class TestCast {

    public static void main(String[] args) {

        Cat cat = new Cat("Barsic", "15");

        System.out.println(cat);

        Animal an =  cat;
        System.out.println(((Dog) an).isDog());

        an.voice();

        System.out.println(an.getClass());
    }
}
