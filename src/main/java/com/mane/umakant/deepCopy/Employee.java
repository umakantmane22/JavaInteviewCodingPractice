package com.mane.umakant.deepCopy;

import java.util.*;

//   2. Employee class with deep copy constructor:
public class Employee {
    private int id;
    private String name; // immutable
    private Date joiningDate; // mutable
    private List<String> skills; // mutable
    private Address address; // mutable custom object

    public Employee(int id, String name, Date joiningDate, List<String> skills, Address address) {
        this.id = id;
        this.name = name;
        this.joiningDate = new Date(joiningDate.getTime()); // deep copy
        this.skills = new ArrayList<>(skills); // deep copy
        this.address = new Address(address); // deep copy
    }

    // Deep copy constructor
    public Employee(Employee other) {
        this(
                other.id,
                other.name,
                new Date(other.joiningDate.getTime()),
                new ArrayList<>(other.skills),
                new Address(other.address)
        );
    }

    public void setSkill(int index, String newSkill) {
        this.skills.set(index, newSkill);
    }

    public void setCity(String newCity) {
        this.address.setCity(newCity);
    }

    public void setJoiningDate(Date newDate) {
        this.joiningDate = newDate;
    }

    @Override
    public String toString() {
        return "Employee { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                ", skills=" + skills +
                ", address=" + address +
                " }";
    }
}


