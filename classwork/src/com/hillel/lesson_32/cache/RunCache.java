package com.hillel.lesson_32.cache;

public class RunCache {

    public static void main(String[] args) {
        Cache cache = new Cache();

        cache.add("1", "1", "1");
        cache.add("2", "1", "1");
        cache.add("2", "2", "1");

        cache.getCache();

        System.out.println();
    }
}
