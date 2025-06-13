package com.mane.umakant.Final.FinalReferenceVariable;

public class FinalRefDemo {
    public static void main(String[] args) {
        final Person p = new Person();
        p.name = "John"; // ✅ Allowed: modifying object's field
        // p = new Person(); // ❌ Error: can't reassign final reference
    }
}
