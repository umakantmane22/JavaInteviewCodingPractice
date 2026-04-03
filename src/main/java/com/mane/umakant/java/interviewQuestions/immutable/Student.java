package com.mane.umakant.java.interviewQuestions.immutable;

import java.util.ArrayList;
import java.util.Collections;
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
        this.subjects = new ArrayList<>(subjects);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Return unmodifiable list (BEST PRACTICE)
    public List<Subjects> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    // Important for production
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subjects);
    }
}