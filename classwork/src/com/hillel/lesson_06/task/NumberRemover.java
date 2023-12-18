package com.hillel.lesson_06.task;

import java.util.Arrays;

//Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива
//(пропусков быть не должно). 1 2 3 4 5 6 4 5 4 - (4) -> 1 2 3 5 6 5
public class NumberRemover {
    public static void main(String[] args) {

        int[]  mass = {1, 2, 3, 4, 5, 4, 6, 4, 6, 4};
        //int[]  mass = {1, 2, 3, 5, 6, 6, 0, 0, 0, 0};

        int remNumber = 4;

        int count = 0;
        for (int i : mass){
            if (i != remNumber){
                count++;
            }
        }

        int[] rez = new int[count];

        int j = 0;
        for (int i = 0; i < mass.length; i++){
            if (mass[i] != remNumber){
                rez[j++] = mass[i];
            }
        }

        System.out.println(Arrays.toString(mass));
        System.out.println(Arrays.toString(rez));

    }
}
