package com.hillel.lesson_31.ex;

public class Child extends Parent{

    @Override
    public void print() {
        System.out.println("child");
    }

    public void printC() {
       this.print();
    }

    public void printP() {
        super.print();
    }

}
