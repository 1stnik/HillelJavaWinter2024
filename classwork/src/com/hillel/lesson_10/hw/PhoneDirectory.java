package com.hillel.lesson_10.hw;

import java.util.ArrayList;

public class PhoneDirectory {

    private ArrayList<Entry> entry = new ArrayList<>();

    public void add(String name, int phoneNumber) {
        entry.add(new Entry(name, phoneNumber));
    }

    public Entry find(String name) {
        for (Entry o : entry) {
            if (o.name.equals(name)) {
                return o;
            }
        }
        return null;
    }

    public ArrayList<Entry> findAll(String name) {
        int check = 0;
        ArrayList<Entry> entry2 = new ArrayList<>();
        for (Entry o : entry) {
            if (o.name.equals(name)) {
                entry2.add(o);
                check++;
            }
        }
        if (check > 0) {
            return entry2;
        }
        return null; //
    }

    public void print(){
        System.out.println(entry);
    }
}
