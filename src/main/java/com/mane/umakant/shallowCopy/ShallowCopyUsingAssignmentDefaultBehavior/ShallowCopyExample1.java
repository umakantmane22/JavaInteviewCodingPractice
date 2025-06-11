package com.mane.umakant.shallowCopy.ShallowCopyUsingAssignmentDefaultBehavior;

public class ShallowCopyExample1 {
    public static void main(String[] args) {
        Person p1 = new Person("John");
        Person p2 = p1; // shallow copy (just reference copy)

        p2.name = "Mike";
        System.out.println(p1.name); // Output: Mike (affected)
    }
}
