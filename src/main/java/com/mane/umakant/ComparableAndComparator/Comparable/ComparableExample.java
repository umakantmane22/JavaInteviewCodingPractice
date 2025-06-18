package com.mane.umakant.ComparableAndComparator.Comparable;

import java.util.*;

public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));

        System.out.println("Before Sorting:");
        printList(employees);

        // Will use compareTo from Employee (sort by age)
        Collections.sort(employees);

        System.out.println("\nAfter Sorting by Age (Default):");
        printList(employees);
    }

    private static void printList(List<Employee> list) {
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }
}
