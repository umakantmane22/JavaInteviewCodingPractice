package com.mane.umakant.Final.finalParameters;

public class FinalParameters {
    public static void main(String[] args) {
        display(5);
    }
    static void display(final int x) {
        // x = 10; // ❌ Error
        System.out.println(x);
    }
}
