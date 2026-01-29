package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceOfEachElementFromGivenArray {
    public static void main(String a[]) {
        // Q36 : find occurence of each element from given array
        // op: {90000=3, 1=1, 22=2, 999=1, 455=2, 9=1}
        int inputArr[] = {1, 90000, 9, 455, 90000, 22, 999, 455, 22, 90000};

        // Using Java8
        Map<Integer, Long> map = Arrays.stream(inputArr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map:: " + map);
        // Using Java7
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (map1.containsKey(inputArr[i])) {
                map1.put(inputArr[i], map1.get(inputArr[i]) + 1);
            } else {
                map1.put(inputArr[i], 1);
            }
        }
        System.out.println("map1:: " + map1);

        List<Integer> inputArrList = Arrays.asList(1, 90000, 9, 455, 90000, 22, 999, 455, 22, 90000);
        // Using Java8
        Map<Integer, Long> map3 = inputArrList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map3:: " + map3);

        // Using Java7
        Map<Integer, Integer> map4 = new HashMap<>();
        for (int i = 0; i < inputArrList.size(); i++) {
            if (map4.containsKey(inputArrList.get(i))) {
                map4.put(inputArrList.get(i), map4.get(inputArrList.get(i)) + 1);
            } else {
                map4.put(inputArrList.get(i), 1);
            }
        }
        System.out.println("map4:: " + map4);

        // below ways are also fine

        Map<Integer, Integer> map5 = new HashMap<>();
        for (Integer i : inputArr) {
            if (map5.containsKey(i)) {
                map5.put(i, map5.get(i) + 1);
            } else {
                map5.put(i, 1);
            }
        }
        System.out.println("map5:: "+map5);

        Map<Integer, Long> map6 = Arrays.stream(inputArr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap<Integer, Long>::new,Collectors.counting()));
        System.out.println("map6:: "+map6);
    }
}
