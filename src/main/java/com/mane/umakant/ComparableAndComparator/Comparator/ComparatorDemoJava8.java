package com.mane.umakant.ComparableAndComparator.Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemoJava8 {
    public static void main(String[] args) {
       List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 50000),
                new Employee("Bob", 25, 60000),
                new Employee("Charlie", 30, 70000),
                new Employee("David", 25, 40000),
                new Employee("Eve", 35, 75000)
        );

       List<Employee> employees1=new ArrayList<>();
       employees1.add(new Employee("Alice", 30, 50000));
       employees1.add(new Employee("Bob", 25, 60000)) ;
       employees1.add(new Employee("Charlie", 30, 70000));
       employees1.add(new Employee("David", 25, 40000));
       employees1.add(new Employee("Eve", 35, 75000));

        System.out.println("🔹 Original List:");
        employees.forEach(System.out::println);

        // 1. Sort by Age (Ascending)
        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("\n🔹 Sorted by Age (Ascending):");
        employees.forEach(System.out::println);

        // 2. Sort by Name (Descending)
        employees.sort(Comparator.comparing(Employee::getName).reversed());
        System.out.println("\n🔹 Sorted by Name (Descending):");
        employees.forEach(System.out::println);

        // 3. Multi-level Sort: Age -> Name -> Salary
        employees.sort(
                Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getName)
                        .thenComparingDouble(Employee::getSalary)
        );
        System.out.println("\n🔹 Multi-level Sort (Age → Name → Salary):");
        employees.forEach(System.out::println);


    }
}
