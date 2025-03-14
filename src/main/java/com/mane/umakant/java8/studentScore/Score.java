package com.mane.umakant.java8.studentScore;

public class Score {
    String subName;
    double subMarks;

    public Score(String subName, double subMarks) {
        this.subName = subName;
        this.subMarks = subMarks;
    }

    public String getSubName() {
        return subName;
    }

    public double getSubMarks() {
        return subMarks;
    }

    @Override
    public String toString() {
        return "Score{" +
                "subName='" + subName + '\'' +
                ", subMarks=" + subMarks +
                '}';
    }
}
