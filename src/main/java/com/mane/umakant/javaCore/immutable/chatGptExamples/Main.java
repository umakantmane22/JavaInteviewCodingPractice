package com.mane.umakant.javaCore.immutable.chatGptExamples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring");

        Address address = new Address("Pune", "Maharashtra");
        Date joinDate = new Date();

        Employee emp = new Employee(101, "Amit", joinDate, skills, address);
        System.out.println("emp before modify:: " + emp);

        // Try to modify original objects
        skills.add("Hacking");
        joinDate.setTime(0);
        address = emp.getAddress();
        address = new Address("Mumbai", "MH");

        System.out.println("skills updated:: " + skills);
        System.out.println("address updated:: " + address);

        // Immutable - Employee object is safe

        //System.out.println(emp.getName());
        //System.out.println(emp.getSkills());       // Will not include "Hacking"
        //System.out.println(emp.getJoiningDate());  // Original date
        //System.out.println(emp.getAddress().getCity()); // Still "Pune"

        System.out.println("emp After modify immutable object is safe:: " + emp);


    }
}
