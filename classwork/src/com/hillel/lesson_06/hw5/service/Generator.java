package com.hillel.lesson_06.hw5.service;

import com.hillel.lesson_06.hw5.copet.Cat;
import com.hillel.lesson_06.hw5.copet.Competitor;
import com.hillel.lesson_06.hw5.copet.Human;
import com.hillel.lesson_06.hw5.copet.Robot;
import com.hillel.lesson_06.hw5.odstacle.Obstacle;
import com.hillel.lesson_06.hw5.odstacle.Road;
import com.hillel.lesson_06.hw5.odstacle.Wall;

public class Generator {

    Competitor[] generateCompetitor(int compNumber) {
        Competitor[] arr = new Competitor[compNumber];

        for (int i = 0; i < compNumber; i++) {
            int number = getRandomNumber(1, 4); // get values from 1 to 3 // stack
            switch (number) {
                case 1 -> arr[i] = new Human("Human_" + i, getRandomNumber(0, 3), getRandomNumber(50 ,100));
                case 2 -> arr[i] = new Cat("Cat_" + i, getRandomNumber(0, 1), getRandomNumber(5, 15));
                case 3 -> arr[i] = new Robot("Robot_" + i, getRandomNumber(0, 10), getRandomNumber(50 ,1000));
            }
        }
        return arr;
    }

    Obstacle[] generateObstacle(int obstNumber) {
        Obstacle[] arr = new Obstacle[obstNumber];

        for (int i = 0; i < obstNumber; i++) {
            int number = getRandomNumber(1, 3); // get values from 1 to 2
            switch (number) {
                case 1 -> arr[i] = new Road(getRandomNumber(0, 1000));
                case 2 -> arr[i] = new Wall(getRandomNumber(0, 4));
            }
        }
        return arr;
    }


    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
