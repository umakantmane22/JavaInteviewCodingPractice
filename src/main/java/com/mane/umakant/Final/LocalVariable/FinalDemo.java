package com.mane.umakant.Final.LocalVariable;

public class FinalDemo {
    public static void main(String[] args) {
        final int x = 10;
        // x = 20; // ❌ Error: cannot assign a value to final variable
        System.out.println(x);
    }
}
