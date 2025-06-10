package com.mane.umakant.javaCore.immutable.chatGptExamples;

import java.util.*;

public final class Employee {

    private final int id;
    private final String name;
    private final Date joiningDate;            // Mutable object
    private final List<String> skills;         // Mutable object
    private final Address address;             // Mutable custom class

    public Employee(int id, String name, Date joiningDate, List<String> skills, Address address) {
        this.id = id;
        this.name = name;

        // Defensive copy to maintain immutability
        this.joiningDate = new Date(joiningDate.getTime());
        this.skills = new ArrayList<>(skills);
        this.address = new Address(address); // Use copy constructor
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Return defensive copy
    public Date getJoiningDate() {
        return new Date(joiningDate.getTime());
    }

    // Return defensive copy
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    // Return defensive copy
    public Address getAddress() {
        return new Address(address);
    }

    // Optional: override toString, equals, hashCode

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", joiningDate=" + joiningDate + ", skills=" + skills + ", address=" + address + '}';
    }
}

