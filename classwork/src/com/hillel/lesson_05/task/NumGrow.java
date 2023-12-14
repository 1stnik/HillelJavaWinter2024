package com.hillel.lesson_05.task;

// Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
public class NumGrow {

    public static void main(String[] args) {
        int[] mass = {1, 25, 1235, 12345};

        for (int i : mass) {
            boolean flag = false;
            if (i < 10) {
                continue;
            }

            String[] str = String.valueOf(i).split("");
            for (int j = 1; j < str.length; j++) {
                if ( Integer.parseInt(str[j]) - Integer.parseInt(str[j - 1]) == 1) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                break;
            }

        }
    }
}
