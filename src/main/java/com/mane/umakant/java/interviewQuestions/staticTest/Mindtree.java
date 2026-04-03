package com.mane.umakant.java.interviewQuestions.staticTest;

public class Mindtree {
    static Mindtree obj = new Mindtree();

    static {
        System.out.println("Static Block");
    }

    {
        System.out.println("Instance Block");
    }

    Mindtree() {
        System.out.println("Constructor");
    }

    public int show() {
        //return (true ? null : 10);  // exception
        return (true ? 0 : 10);
    }

    public static void main(String[] args) {
        System.out.println("Main Started");
        Mindtree m = new Mindtree();
        System.out.println(m.show());
    }
}
