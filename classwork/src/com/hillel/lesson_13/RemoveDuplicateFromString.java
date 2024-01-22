package com.hillel.lesson_13;

public class RemoveDuplicateFromString {

    public static void main(String[] args) {

        // abdcdc -> abdc
        System.out.println(clean("assdasd"));
    }

    private static String clean(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.indexOf(str.charAt(i)) != i) {
                str = str.substring(0, i).concat(str.substring(i + 1));
            }
        }
        return str;
    }
}
