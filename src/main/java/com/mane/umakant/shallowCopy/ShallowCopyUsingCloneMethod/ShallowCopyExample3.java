package com.mane.umakant.shallowCopy.ShallowCopyUsingCloneMethod;

import java.util.Arrays;

public class ShallowCopyExample3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        String[] subs = { "Math", "Science" };
        Student s1 = new Student(1, subs);
        Student s2 = s1.clone(); // shallow copy

        s2.subjects[0] = "History";

        System.out.println(Arrays.toString(s1.subjects)); // Output: [History, Science]
    }
}
