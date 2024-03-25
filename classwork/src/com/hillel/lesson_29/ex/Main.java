package com.hillel.lesson_29.ex;

public class Main {
    public static void main(String[] args) {
        String[] phoneNumbers = {
                "37061234567",
                "+37061234567",
                "+370(6)1234567",
                "+370(6)1234567",
                "+370 612 34 567",
                "+370-612-34-567"
        };

        for (String phoneNumber : phoneNumbers) {
            String normalizedNumber = normalizePhoneNumber(phoneNumber);
            System.out.println("Original: " + phoneNumber + " | Normalized: " + normalizedNumber);
        }
    }

    public static String normalizePhoneNumber(String phoneNumber) {
        return null;
    }
}
