package com.mane.umakant.callByReference.ModifyingAnObject;

//  You're reassigning the local copy of the reference.
//  The original object remains unchanged.
public class DemoReassigningObject {
    public static void reassign(Person p) {
        p = new Person();  // Creates a new object
        p.name = "Sam";
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John";

        reassign(person);
        System.out.println(person.name);  // Output: John ❌
    }
}
