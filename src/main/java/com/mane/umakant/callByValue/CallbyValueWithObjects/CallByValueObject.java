package com.mane.umakant.callByValue.CallbyValueWithObjects;

// Java passes the value of the reference, not the actual object. So, the reference is copied, and both references point to the same object.
public class CallByValueObject {
    public static void modify(Person p) {
        p.name = "Mike"; // Modifies the object
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John";

        modify(person);
        System.out.println(person.name); // Output: Mike

        reassign(person);
        System.out.println("reassign:: "+person.name);
    }
    public static void reassign(Person p) {
        p = new Person();     // creates a new object
        p.name = "Sam";
    }
}
