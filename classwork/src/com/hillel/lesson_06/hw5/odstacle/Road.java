package com.hillel.lesson_06.hw5.odstacle;

public class Road extends Obstacle {
    private int length;

    public Road(int height) {
        this.length = height;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Road{" +
            "length=" + length +
            '}';
    }
}
