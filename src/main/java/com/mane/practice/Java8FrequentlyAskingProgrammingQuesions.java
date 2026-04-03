package com.mane.practice;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8FrequentlyAskingProgrammingQuesions {
    public static void main(String[] args) {
        // Q13 find square of each element take value >100 and find average.
        // e.g. input: List<Integer> list1=Arrays.asList(10,20,30,15);
        // 100,400,900,225
        // 400,900,225
        // 1525/3=508.33333

        List<Integer> list = Arrays.asList(10, 20, 30, 15);

        System.out.println(
                list.stream()
                        .map(sqr->sqr*sqr)
                        .filter(v->v>100)
                        .collect(Collectors.averagingDouble(Integer::valueOf))
        );
    }
}

