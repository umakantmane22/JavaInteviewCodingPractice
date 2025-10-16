package com.mane.umakant.collections.chatGpt;
import java.util.*;
public class ImmutableEmployeeListExample {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "John", new Date()));
        employeeList.add(new Employee(102, "Emma", new Date()));

        // Make it immutable
        List<Employee> immutableList = Collections.unmodifiableList(employeeList);

        System.out.println("Immutable Employee List: " + immutableList);

        // immutableList.add(new Employee(103, "Mark", new Date())); // ❌ Throws exception
    }

}
