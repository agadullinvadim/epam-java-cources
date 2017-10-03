package com.epam.university.java.core.task011;

import java.util.*;
import java.util.stream.Collectors;

public class Task011Impl implements Task011 {

    public boolean isLast(String[] input) {
        int count = 0;
        for (String element : input) {
            if (element != null) {
                count++;
            }
        }
        return count != 1;
    }

    @Override
    public String getLastName(String[] collection) {
        if (collection.length == 0) {
            throw new IllegalArgumentException();
        }
        return findTheLastOne(collection);
    }

    private String findTheLastOne(String[] collection) {
        if (collection.length == 1) {
            return collection[0];
        }
        boolean isFirst = true;
        int i;
        int j = 0;
        String[] nextCollection;
        String name = null;

        while (true) {
            i = 0;
            j = 0;
            int end = collection.length;
            if (end % 2 == 0) {
                nextCollection = new String[end / 2];
            } else if (end % 2 != 0 && isFirst) {
                nextCollection = new String[end / 2];
            } else {
                nextCollection = new String[(end / 2) + 1];
            }
            if (!isFirst) {
                i = 1;
                nextCollection[0] = collection[0];
            }

            for (; i <= end - 1 || i <= end - 2; ) {
                name = collection[i];
                if (i != end - 1) {
                    nextCollection[j] = collection[i + 1];
                }
                j++;
                collection[i] = null;
                isFirst = true;
                if (i == collection.length - 1) {
                    isFirst = false;
                }
                i = i + 2;
            }
            if (nextCollection.length == 2 && isFirst) {
                name = nextCollection[1];
                break;
            }
            if (nextCollection.length == 1) {
                name = nextCollection[0];
                break;
            }
            collection = nextCollection;
            nextCollection = new String[0];
        }
        return name;

    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        Collection<String> c = collection;
        List<String> collect = c.stream().filter(t -> t != null).collect(Collectors.toList());
        return null;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        return null;
    }
}
