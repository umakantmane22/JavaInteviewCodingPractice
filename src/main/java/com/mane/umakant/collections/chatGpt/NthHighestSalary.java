package com.mane.umakant.collections.chatGpt;

import java.util.*;
import java.util.stream.Collectors;

public class NthHighestSalary {
    public static void main(String[] args) {
        List<Integer> salaries = Arrays.asList(1000, 2000, 3000, 2000, 5000, 4000);
        int N = 3; // Find 3rd highest salary
        System.out.println("salary in desc order as below:  " +
                salaries.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
        );
        // Remove duplicates, sort descending, get Nth element
        List<Integer> sortedSalaries = salaries.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (N <= sortedSalaries.size()) {
            System.out.println(N + "th highest salary: " + sortedSalaries.get(N - 1));
        } else {
            System.out.println("Not enough salaries in the list");
        }

        // Java 7 Approach (using Collections)
        // Remove duplicates
        Set<Integer> salarySet = new HashSet<>(salaries);
        System.out.println("salarySet:: " + salarySet);

        List<Integer> distinctSalaries = new ArrayList<>(salarySet);
        System.out.println("distinctSalaries:: " + distinctSalaries);

        // Sort descending

        Collections.sort(distinctSalaries, Collections.reverseOrder());
        if (N <= distinctSalaries.size()) {
            System.out.println(N + "th highest salary: " + distinctSalaries.get(N - 1));
        } else {
            System.out.println("Not enough salaries in the list");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer salary : new HashSet<>(salaries)) {
            minHeap.offer(salary);
            if (minHeap.size() > N) {
                minHeap.poll();
            }
        }
        System.out.println(N + "th highest salary: " + minHeap.peek());

    }
}
