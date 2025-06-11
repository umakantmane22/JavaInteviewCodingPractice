package com.mane.umakant.callByReference.ModifyingAnObject;

// Example: Modifying an Object (Looks like call by reference)
// The reference is passed by value.
//Inside changeName, you're modifying the actual object using that reference copy.
public class DemoModifyingAnObject {
    public static void changeName(Person p) {
        p.name = "Mike";
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John";

        changeName(person);
        System.out.println(person.name);  // Output: Mike ✅
    }
}
