package com.mane.umakant.ComparableAndComparator.Comparable.Java8;

import java.util.*;

public class ComparableJava8Example {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 50000),
                new Employee("Bob", 25, 60000),
                new Employee("Charlie", 35, 55000)
        );

        // Sort using Comparable (by age)
        Collections.sort(employees); // calls compareTo()

        System.out.println("Sorted by Age (Natural Order - Comparable):");
        employees.forEach(System.out::println);

        // Java 8: sort by name using stream
        System.out.println("\nSorted by Name (Stream + Comparator):");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        // Java 8: sort by salary descending using stream
        System.out.println("\nSorted by Salary Descending (Stream + Comparator):");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
