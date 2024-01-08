package com.hillel.lesson_08.task;

public class PusUp {

    /*
    Человек подтягивается, делает подходы лесенкой начиная с 1 раза
    - подсчитать сколько он всего подтянеться за N подходов, N задано с клавиатуры
    N = 4 -> 1 + 2 + 3 + 4 = 10

    - вывести общее время выполнения упражнения (10:45)
    каждое подтягивание занимает 5с, первый перерыв между подходами 60с,
    каждый следующий перерыв на 20% больше предыдущего.
     */
    public static void main(String[] args) throws InterruptedException {

        int attempt = 10;

        int pushUpTime = 5;
        int restTime = 60;
        double restTimeCoef = 1.2;

        int totalTime = 0;
        int totalPushups = 0;

        for (int i = 1; i <= attempt; i++) {
            System.out.println("attempt # " + i);
            for (int j = 0; j < i; j++) {
                totalTime += pushUpTime;
                totalPushups++;
                System.out.print("#");
            }
            if (i < attempt){
                totalTime += restTime;
                restTime = (int) (restTime*restTimeCoef);
            }

            System.out.println();

        }

        System.out.println(totalTime);
        System.out.println(totalPushups);

        System.out.println("total time -> " + totalTime / 60 + " min " + totalTime % 60 + " s");
    }
}
