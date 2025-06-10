package com.mane.umakant.javaCore.immutable.chatGptExamples;

import java.util.*;

// Requirements for an Immutable Class:

//Class must be final
//All fields should be private and final
//No setters (only getters)
//No method should modify the object’s state
//If the class contains mutable fields (like Date, List, custom objects), return defensive copies in getters and use defensive copies in the constructor

// immutable class should be final because it can not be extendible
public final class Employee {

    // All variable should be final because of contents  can not be changed.
    private final int id;
    private final String name;
    private final Date joiningDate;            // Mutable object
    private final List<String> skills;         // Mutable object
    private final Address address;             // Mutable custom class

    // provide parameterised constructor
    public Employee(int id, String name, Date joiningDate, List<String> skills, Address address) {
        this.id = id;  // Integer and String, All wrapper by default immutable
        this.name = name;

        // Defensive copy to maintain immutability
        this.joiningDate = new Date(joiningDate.getTime()); // Use deep copy constructor
        this.skills = new ArrayList<>(skills); // Use deep copy constructor
        this.address = new Address(address); // Use deep copy constructor
    }

    // dont provide setter methods. Only provide getter methods
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
        return new ArrayList<>(skills); // different copy of set has been return e.g // copy constructor
    }

    // Return defensive copy
    public Address getAddress() {
        return new Address(address); // different copy of address  has been return e.g // copy constructor
    }

    // Optional: override toString, equals, hashCode

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", joiningDate=" + joiningDate + ", skills=" + skills + ", address=" + address + '}';
    }
}

