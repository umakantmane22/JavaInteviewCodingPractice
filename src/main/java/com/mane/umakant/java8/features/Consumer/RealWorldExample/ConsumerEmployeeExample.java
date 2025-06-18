package com.mane.umakant.java8.features.Consumer.RealWorldExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEmployeeExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000)
        );

        Consumer<Employee> giveBonus = emp -> emp.salary += 5000;
        employees.forEach(giveBonus);
        employees.forEach(System.out::println);
    }
}
// output
//Alice => 55000.0
//Bob => 65000.0