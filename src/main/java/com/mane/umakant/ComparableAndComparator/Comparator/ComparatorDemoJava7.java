package com.mane.umakant.ComparableAndComparator.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemoJava7 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 30, 70000));
        employees.add(new Employee("David", 25, 40000));
        employees.add(new Employee("Eve", 35, 75000));

        System.out.println("Original List:");
        printList(employees);

        // 1. Sort by Age (Ascending)
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getAge() - e2.getAge();
            }
        });

        System.out.println("\nSorted by Age (Ascending):");
        printList(employees);

        // 2. Sort by Name (Alphabetical)
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        System.out.println("\nSorted by Name:");
        printList(employees);

        // 3. Sort by Salary (Descending)
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });

        System.out.println("\nSorted by Salary (Descending):");
        printList(employees);
    }

    private static void printList(List<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
