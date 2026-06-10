package com.mane.umakant.java.interviewQuestions.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Natural ordering by ID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(3, "Amit", 50000));
        list.add(new Employee(1, "Rahul", 70000));
        list.add(new Employee(2, "Neha", 60000));

        System.out.println("Before Sorting:");
        list.forEach(System.out::println);

        Collections.sort(list); // Uses compareTo()

        System.out.println("\nAfter Sorting (by ID - Comparable):");
        list.forEach(System.out::println);
    }
}
