package com.mane.umakant.java.interviewQuestions.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee(3, "Amit", 50000),
                new Employee(1, "Rahul", 70000),
                new Employee(2, "Neha", 60000)
        );

        System.out.println("Original List:");
        list.forEach(System.out::println);

        // Sort by Name
        list.sort(Comparator.comparing(Employee::getName));

        System.out.println("\nSorted by Name:");
        list.forEach(System.out::println);

        // Sort by Salary (Descending)
        list.sort(Comparator.comparing(Employee::getSalary).reversed());

        System.out.println("\nSorted by Salary (Descending):");
        list.forEach(System.out::println);

        // Multiple sorting (Name then Salary)
        list.sort(Comparator
                .comparing(Employee::getName)
                .thenComparing(Employee::getSalary));

        System.out.println("\nSorted by Name then Salary:");
        list.forEach(System.out::println);
    }
}
