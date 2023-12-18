package com.hillel.lesson_06.hw5.odstacle;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean overcome(int value){
        return  value < height;
    }

    @Override
    public String toString() {
        return "Wall{" +
            "height=" + height +
            '}';
    }
}
