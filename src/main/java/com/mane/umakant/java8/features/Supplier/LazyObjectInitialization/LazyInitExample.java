package com.mane.umakant.java8.features.Supplier.LazyObjectInitialization;

import java.util.function.Supplier;

public class LazyInitExample {
    public static void main(String[] args) {
        Supplier<ExpensiveObject> objectSupplier = () -> new ExpensiveObject();

        System.out.println("Before calling get()");
        ExpensiveObject obj = objectSupplier.get(); // Lazy init here
        System.out.println("After calling get(): " + obj);
    }
}
