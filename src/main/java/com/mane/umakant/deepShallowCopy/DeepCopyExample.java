package com.mane.umakant.deepShallowCopy;

public class DeepCopyExample {
    public static void main(String[] args) {

        Address address = new Address("Delhi");
        Person p1 = new Person("Amit", address);

        // Deep copy
        Address newAddress = new Address(p1.address.city);
        Person p2 = new Person(p1.name, newAddress);

        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // Delhi
        System.out.println(p2.address.city); // Mumbai
    }
}

