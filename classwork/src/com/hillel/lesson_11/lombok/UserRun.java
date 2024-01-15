package com.hillel.lesson_11.lombok;

public class UserRun {

    public static void main(String[] args) {

        User us = new User();

        us.setName("Alex");
        us.setPhone("phone");
        us.setEmail("email");

        System.out.println(us);

        System.out.println(User.builder()
                .name("Oleksandr")
                .phone("olPhone")
                .email("olEmail")
            .build());
    }

}
