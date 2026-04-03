package com.mane.umakant.solid.SingleResponsibilityPrinciple;

/*
Now each class has only one responsibility.
Employee (Data Model)*/
public class Employee {
    private String name;
    private int hours;

    public Employee(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

}
