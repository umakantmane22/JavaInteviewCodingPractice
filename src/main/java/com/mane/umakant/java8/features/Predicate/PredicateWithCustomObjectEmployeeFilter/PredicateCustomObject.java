package com.mane.umakant.java8.features.Predicate.PredicateWithCustomObjectEmployeeFilter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PredicateCustomObject {
    public static void main(String[] args) {
        List<Employee> employees= Arrays.asList(
                new Employee("John", 25, 50000),
                new Employee("Jane", 30, 60000),
                new Employee("Alex", 35, 45000)
        );

        Predicate<Employee> salaryGreaterThan5000=employee -> employee.salary>5000;
        employees.stream()
                .filter(salaryGreaterThan5000)
                .forEach(System.out::println); // Jane - Age: 30 - Salary: 60000.0
        System.out.println("Get max salary------");
        // Step 1: Get max salary not using predicate
        Optional<Employee> isHighestSalaryRecord = employees.stream()
                .max(Comparator.comparing(employee -> employee.salary));
        System.out.println("isHighestSalaryRecord:: "+isHighestSalaryRecord);

    }
}
