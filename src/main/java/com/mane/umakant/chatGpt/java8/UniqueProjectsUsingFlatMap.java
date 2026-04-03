package com.mane.umakant.chatGpt.java8;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private List<String> projects;

    public Employee(String name, List<String> projects) {
        this.name = name;
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }
}
public class UniqueProjectsUsingFlatMap {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Arrays.asList("HR System", "Payroll System")),
                new Employee("Bob", Arrays.asList("Inventory System", "Payroll System")),
                new Employee("Charlie", Arrays.asList("HR System", "Recruitment Portal"))
        );

        // Use flatMap() to flatten project lists and get unique names
        List<String> uniqueProjects = employees.stream()
                .flatMap(emp -> emp.getProjects().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique Project Names: " + uniqueProjects);
    }
}
