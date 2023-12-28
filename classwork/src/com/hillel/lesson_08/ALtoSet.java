package com.hillel.lesson_08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ALtoSet {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(1);
        l.add(2);
        l.add(4);
        System.out.println(l);

        Set set = new HashSet(l);

        System.out.println(set);


    }

}
