package com.mane.umakant.immutable.UsingJava17recordForImmutableDataClass;

public record Student(String name, int rollNumber) {
}

//record classes are implicitly:
//final
//private final fields
//getters only
//equals(), hashCode(), toString() auto-generated
