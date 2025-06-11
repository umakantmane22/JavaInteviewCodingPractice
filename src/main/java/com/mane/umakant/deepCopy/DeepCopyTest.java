package com.mane.umakant.deepCopy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeepCopyTest {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring");

        Date joinDate = new Date();
        Address address = new Address("Mumbai", "India");

        Employee original = new Employee(101, "Amit", joinDate, skills, address);
        Employee deepCopy = new Employee(original); // Deep Copy

        // Mutate original
        skills.set(0, "Hacking");
        joinDate.setTime(0);
        address.setCity("Pune");

        // Output original and copy to see the difference
        System.out.println("Original : " + original);
        System.out.println("Deep Copy: " + deepCopy);
        System.out.println("---------------");
        System.out.println("mutable skills obj:: "+skills);
        System.out.println("mutable joinDate obj:: "+joinDate);
        System.out.println("mutable address obj:: "+address);
    }
}
