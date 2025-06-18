package com.mane.umakant.java8.features.Consumer.RealWorldExample;

public class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " => " + salary;
    }
}
