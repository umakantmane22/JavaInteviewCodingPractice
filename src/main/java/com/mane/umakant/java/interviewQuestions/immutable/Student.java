package com.mane.umakant.java.interviewQuestions.immutable;

import java.util.List;
import java.util.Objects;

public final class Student {

    private final int id;
    private final String name;
    private final List<Subjects> subjects;

    public Student(int id, String name, List<Subjects> subjects) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "Name cannot be null");

        // Defensive copy + null check
        Objects.requireNonNull(subjects, "Subjects cannot be null");
        // Recommended Version
        this.subjects = List.copyOf(subjects);

       /*
        // If Subject class is also immutable then below correct. No issue
        this.subjects = new ArrayList<>(subjects);

        Option 2: Deep Copy (if Subjects is mutable)
        this.subjects=subjects.stream()
               .map(s-> new Subjects(s.getId(), s.getName(), s.getMarks()))
               .collect(Collectors.toList());

         */

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Return unmodifiable list (BEST PRACTICE)
    public List<Subjects> getSubjects() {
        // Recommended Version
        return subjects;
        /*
        // // If Subject class is also immutable then below code is correct. No issue
        // return Collections.unmodifiableList(subjects);
          return new ArrayList<>(subjects);
            Option 2: Deep Copy (if Subjects is mutable)
         return subjects.stream()
                .map(s -> new Subjects(s.getId(), s.getName(), s.getMarks()))
                .collect(Collectors.toList());
         */


    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", subjects=" + subjects + '}';
    }

    // Important for production
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subjects);
    }
}