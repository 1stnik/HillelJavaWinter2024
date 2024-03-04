package com.hillel.lesson_25.reflection;

public class Test {

    String name;
    String email;

    public Test() {
    }

    public Test(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Test{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
