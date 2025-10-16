package com.mane.umakant.collections.chatGpt;
import java.util.*;
public class ImmutableEmployeeListJava9 {
    public static void main(String[] args) {
        List<Employee> immutableEmployees = List.of(
                new Employee(101, "John", new Date()),
                new Employee(102, "Emma", new Date())
        );

        System.out.println("Immutable Employees: " + immutableEmployees);
    }

}
