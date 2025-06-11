package com.mane.umakant.callByValue.CallbyValuewithPrimitives;

//  Java copies the actual value of the primitive variable into the method.
public class CallByValuePrimitive {
    public static void modify(int a) {
        a = a + 10;
    }

    public static void main(String[] args) {
        int num = 5;
        modify(num);
        System.out.println(num);  // Output: 5 (unchanged)
        // The original value of num does not change.
    }
}

