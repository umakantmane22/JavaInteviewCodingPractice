package com.mane.umakant.immutable.BasicImmutableClassWithPrimitives;

public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // No setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

