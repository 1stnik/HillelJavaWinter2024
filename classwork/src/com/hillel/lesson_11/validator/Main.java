package com.hillel.lesson_11.validator;

import com.hillel.lesson_11.validator.exceptions.AgeException;
import com.hillel.lesson_11.validator.exceptions.EmailException;
import com.hillel.lesson_11.validator.exceptions.PhoneValidationException;

public class Main {
    public static void main(String[] args) {

        try {
            new UserValidator().validate(new
                    User(
                            "Alex",
                            "St@mail.com",
                            19,
                            "+380505673214"));
        } catch (AgeException | EmailException | PhoneValidationException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            new UserValidator().valid(new
                    User("Alex", "Stmail.com", 8, "+80505673214"));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
//
//        new UserValidator().validate(new
//                User("Alex", "St@mail.com", 18, "+380505673214"));

//        new UserValidator().valid(new
//                User("Alex", "Stmail.com", 2, "380505673214"));
//
//        String s = new String();

    }
}
