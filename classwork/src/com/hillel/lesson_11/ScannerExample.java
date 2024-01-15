package com.hillel.lesson_11;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean correct;
        System.out.println("Введіль цифру: ");
        String s;
        do {
            s = scanner.nextLine();
            correct = false;
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                System.out.println(s + " це не цифра. Введіть цифру знову");
                correct = true;
            }

        } while (correct);

        System.out.println(s);
    }

}
