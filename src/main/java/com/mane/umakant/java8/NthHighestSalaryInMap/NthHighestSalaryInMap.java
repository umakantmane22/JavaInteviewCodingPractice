package com.mane.umakant.java8.NthHighestSalaryInMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NthHighestSalaryInMap {
    // find second highest salary
    public static void main(String[] args) {
        // Tricky question
        Map<String, Integer> map2 = new HashMap<>();

        map2.put("anil", 1000);
        map2.put("bhavana", 1300);
        map2.put("micael", 1500);
        map2.put("tom", 1600);
        map2.put("ankit", 1200);
        map2.put("daniel", 1700);
        map2.put("james", 1400);

        map2.put("umesh", 1000);
        map2.put("umakant", 1200);
        map2.put("rahul", 1200);
        map2.put("ramesh", 1200);
        map2.put("vijay", 1000);
        map2.put("shruti", 1300);
        map2.put("daniel_1", 1700);
        map2.put("harsh", 1300);
        map2.put("tom1", 1600);

        // Find the second highest salary employee(s)

        Entry<Integer, List<String>> second_highest_salary_employee = map2.entrySet().stream()
                .collect(
                        Collectors.groupingBy(
                                Entry::getValue,
                                Collectors.mapping(
                                        Entry::getKey,
                                        Collectors.toList()
                                )
                        )
                )
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(1); // 0=highest,1=second last,2=third last etc
        System.out.println("second_highest_salary_employee:: " + second_highest_salary_employee);
     /*   System.out.println(

                map2.entrySet().stream()
                        .collect(
                                Collectors.groupingBy(
                                        Entry::getValue,
                                        Collectors.mapping(
                                                Entry::getKey,
                                                Collectors.toList())))
                        .entrySet().stream()
                        .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                        .collect(Collectors.toList())


        );
        System.out.println("highest:: " +

                map2.entrySet().stream()
                        .collect(Collectors.groupingBy(Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toList())))
                        .entrySet().stream()
                        .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                        .collect(Collectors.toList())
                        .get(0) // 0=highest,
        );
        System.out.println("secondHighest:: " +

                map2.entrySet().stream()
                        .collect(Collectors.groupingBy(Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toList())))
                        .entrySet().stream()
                        .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                        .collect(Collectors.toList())
                        .get(1) // 1=second highest,
        );
        System.out.println("thirdHighest:: " +

                map2.entrySet().stream()
                        .collect(Collectors.groupingBy(Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toList())))
                        .entrySet().stream()
                        .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                        .collect(Collectors.toList())
                        .get(2) // 2=third highest,
        );
        */
        // find groupByValue
        Map<Integer, List<Entry<String, Integer>>> groupByValue = map2.entrySet().stream()
                .collect(Collectors.groupingBy(Entry::getValue));
        System.out.println("groupByValue:: "+groupByValue);
        // find groupByValueAndNames
        Map<Integer, List<String>> groupByValueAndNames = map2.entrySet().stream()
                .collect(Collectors.groupingBy(Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toList())));
        System.out.println("groupByValueAndNames:: "+groupByValueAndNames);

        // New Approch From ChatGpt
        // Find the second highest salary employee(s)
        int secondHighestSalary = map2.values().stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No second highest salary"));
        List<String> employees = map2.entrySet().stream()
                .filter(entry -> entry.getValue() == secondHighestSalary)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Second highest salary: " + secondHighestSalary);
        System.out.println("Employees with second highest salary: " + employees);
        System.out.println("//////////////////////");
        int secondHighestSalary2 = map2.values().stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();

        List<String> employees2 = map2.entrySet().stream()
                .filter(e -> e.getValue().equals(secondHighestSalary2))
                .map(Map.Entry::getKey)
                .sorted() // optional, sorts names alphabetically
                .toList();

        System.out.println("secondHighest:: " + secondHighestSalary2 + "=" + employees2);
    }


}
