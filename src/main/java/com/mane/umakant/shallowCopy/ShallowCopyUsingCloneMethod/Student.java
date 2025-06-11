package com.mane.umakant.shallowCopy.ShallowCopyUsingCloneMethod;

public class Student implements Cloneable{
    int rollNo;
    String[] subjects;

    Student(int rollNo, String[] subjects) {
        this.rollNo = rollNo;
        this.subjects = subjects;
    }

    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone(); // shallow copy
    }
}
