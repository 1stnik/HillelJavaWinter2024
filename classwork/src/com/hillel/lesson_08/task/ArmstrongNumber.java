package com.hillel.lesson_08.task;

/*
    Напишите Java-программу для проверки является ли введенное число - числом Армстронга.
    Прежде всего, нам нужно понять, что такое число Армстронга.
    Число Армстронга это число, значение которого равно сумме цифр,
    из которых оно состоит, возведенных в степень, равную количеству
    цифр в этом числе.

    Как пример - число 371:
    371 = 3*3*3 + 7*7*7 + 1*1*1 = 27 + 343 + 1 = 371
    Если у вас число четырехзначное:
    8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8 = 4096 + 16 + 0 + 4096 = 8208.

    вывести первые N чисел
 */
public class ArmstrongNumber {

    public static void main(String[] args) {

        int total = 0;

        for (int i = 0; i < 50; ) {
            if (isArmstrongNumber(total++)) {
                System.out.println(total);
                i++;
            }

        }

    }

    public static boolean isArmstrongNumber(Integer number) {

        String[] split = String.valueOf(number).split("");

        int pow = split.length;

        int result = 0;

        for (String s : split) {
            Integer i = Integer.valueOf(s);

            result += (int) Math.pow(i, pow);
        }
        return result == number;
    }
}
