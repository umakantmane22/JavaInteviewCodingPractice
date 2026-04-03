package com.mane.umakant.java.interviewQuestions.immutable;

import java.util.Objects;

public final class Subjects {

    private final int id;
    private final String name;
    private final double marks;

    public Subjects(int id, String name, double marks) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "Subject name cannot be null");
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    // Production standard
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subjects)) return false;
        Subjects that = (Subjects) o;
        return id == that.id &&
                Double.compare(that.marks, marks) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, marks);
    }
}