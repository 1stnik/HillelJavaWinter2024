package org.example;

import java.lang.reflect.Field;

/**
 * @author  Oleksandr Stepurko
 * @version 0.0.1
 * @since 04.03.2024
 */
public class Run {

    /**
     * This Java program demonstrates how to use reflection
     * to modify the internal character array of a String object.
     *
     * @param args - arguments for application
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        String str = "text";
        System.out.println(str);
        Class fn = str.getClass();
        Field field = fn.getDeclaredField("value");
        field.setAccessible(true);
        field.set(str, "WTF".getBytes());
        System.out.println(str);
    }
}
