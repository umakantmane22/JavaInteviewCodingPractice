package com.mane.umakant.deepShallowCopy;

public class ShallowCopyExample {
    public static void main(String[] args) {

        Address address = new Address("Delhi");
        Person p1 = new Person("Amit", address);

        // Shallow copy
        Person p2 = new Person(p1.name, p1.address);

        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // Mumbai
        System.out.println(p2.address.city); // Mumbai
    }
}

