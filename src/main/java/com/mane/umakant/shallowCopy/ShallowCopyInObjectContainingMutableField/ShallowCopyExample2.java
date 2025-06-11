package com.mane.umakant.shallowCopy.ShallowCopyInObjectContainingMutableField;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyExample2 {
    public static void main(String[] args) {
        List<String> skillSet = new ArrayList<>();
        skillSet.add("Java");

        Employee e1 = new Employee(1, skillSet);
        Employee e2 = new Employee(e1); // shallow copy

        e2.skills.add("Python");

        System.out.println("e1.skills: " + e1.skills); // Output: [Java, Python]
        System.out.println("e2.skills: " + e2.skills); // Output: [Java, Python]
    }
}
