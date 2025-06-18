package com.mane.umakant.java8.features.Supplier.LazyObjectInitialization;

public class ExpensiveObject {
    public ExpensiveObject() {
        System.out.println("Object created!");
    }

    public String toString() {
        return "I’m heavy to create!";
    }
}
