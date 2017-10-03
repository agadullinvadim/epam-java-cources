package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl3 implements Task011{

    public static boolean isLast(String[] input){
        int count = 0;
        for (String element: input) {
            if (element != null){
                count++;
            }
        }
        return count != 1;
    }
    public String getLastName(String[] collection) {
        int index = 0;
        int length = collection.length;
        String name = collection[index];
        while(isLast(collection)){
            if (collection[index] != null) {
                if (index == length - 1) {
                    name = collection[index];
                    collection[index] = null;
                    index = 3;
                } else if (index == length - 2) {
                    name = collection[index];
                    collection[index] = null;
                    index = 1;
                } else {
                    name = collection[index];
                    collection[index] = null;
                    index = index + 2;
                }
            }

        }
        return name;
    }


    public String getLastName(ArrayList<String> collection) {
        return null;
    }


    public String getLastName(LinkedList<String> collection) {
        return null;
    }
    public static void main(String[] args) {

        final String[] collection = {
            "Homer",
            "Bart",
            "Maggie",
            "Lisa",
            "Marge",
            "Nelson"
        };
        Task011 t = new Task011Impl3();
        System.out.println(t.getLastName(collection));
    }
}
