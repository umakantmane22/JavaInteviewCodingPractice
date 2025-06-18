package com.mane.umakant.java8.features.Supplier.SupplyString;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplyHello = () -> "Hello from Supplier!";
        System.out.println(supplyHello.get());
    }
}
// output:: Hello from Supplier!
