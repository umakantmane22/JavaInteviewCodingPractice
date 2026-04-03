package com.mane.umakant.java.interviewQuestions.immutable;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable {

    public static void main(String[] args) {

        List<Subjects> subjectList = new ArrayList<>();
        subjectList.add(new Subjects(1, "Math", 90));
        subjectList.add(new Subjects(2, "Science", 85));

        Student student = new Student(101, "Umakant", subjectList);

        System.out.println("Original Student:");
        System.out.println(student);

        // ✅ Test 1: Modify original list after object creation
        subjectList.add(new Subjects(3, "History", 70));

        System.out.println("\nAfter modifying original list:");
        System.out.println(student); // should NOT change

        // ✅ Test 2: Try modifying through getter
        try {
            student.getSubjects().add(new Subjects(4, "English", 88));
        } catch (UnsupportedOperationException e) {
            System.out.println("\nModification blocked! Immutable object protected.");
        }

        // ✅ Test 3: Check deep immutability
        Subjects subject = student.getSubjects().get(0);
        System.out.println("\nAccessed Subject:");
        System.out.println(subject);

        // No setter → cannot modify
        // subject.setMarks(100); ❌ not possible

        // ✅ Test 4: Equality check
        Student student2 = new Student(101, "Umakant", subjectList);

        System.out.println("\nEquality Test:");
        System.out.println(student.equals(student2)); // should be false (different subjects)


    }
}