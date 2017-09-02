package com.epam.university.java.core.task003;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ilya on 02.09.17.
 */
public class Task003Impl implements Task003 {
    private final NullChecker checker;

    public Task003Impl() {
        this.checker = new SimpleNullChecker();
    }

    @Override
    public String[] invert(String[] source) {
        checker.check(source);

        String[] result = new String[source.length];

        for (int i = 0; i < source.length; i++) {
            result[source.length-i-1] = source[i];
        }

        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        checker.check(first,second);

        String[] result = new String[first.length+second.length];

        List<String> resultList = new ArrayList<>();
        resultList.addAll(Arrays.asList(first));
        resultList.addAll(Arrays.asList(second));

        return resultList.toArray(result);
    }

    @Override
    public int findMax(int[] source) {
        checker.check(source);
        int max = Integer.MIN_VALUE;

        for (int element :
                source) {
            if (element > max)max = element;
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        checker.check(source, condition);
        String[] result = new String[0];
        List<String> resultList = Arrays.asList(source)
                                        .stream()
                                        .filter(n -> condition.isValid(n))
                                        .collect(Collectors.toList());



        return resultList.toArray(result);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        checker.check(source,toRemote);

        String[] result = new String[0];
        List<String> resultList = new ArrayList<>();

        resultList.addAll(Arrays.asList(source));
        resultList.removeAll(Arrays.asList(toRemote));


        return resultList.toArray(result);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        checker.check(source,operation);

        String[] result = new String[0];
        List<String> resultList = Arrays.asList(source).stream().map(n -> operation.map(n)).collect(Collectors.toList());

        return resultList.toArray(result);
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        checker.check(source,operation);

        Set<String> stringSet = new TreeSet<>();

        List<String> sourceList = Arrays.asList(source).stream().map(n -> operation.flatMap(n)).collect(Collectors.toList());

        return null;
    }
}
