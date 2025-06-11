package com.mane.umakant.shallowCopy.ShallowCopyInArrays;

public class ShallowCopyArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        int[] copy = original; // shallow copy

        copy[0] = 99;

        System.out.println(original[0]); // Output: 99
    }
}
