package com.mane.umakant.shallowCopy.ShallowCopyInObjectContainingMutableField;

import java.util.List;

public class Employee {
    int id;
    List<String> skills;

    Employee(int id, List<String> skills) {
        this.id = id;
        this.skills = skills;
    }

    Employee(Employee other) { // shallow copy constructor
        this.id = other.id;
        this.skills = other.skills; // reference copy!
    }
}
