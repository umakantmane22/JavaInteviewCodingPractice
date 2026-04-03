package com.mane.umakant.solid.InterfaceSegregationPrinciple;

// Step 2 — Implement only required interfaces
public class HumanWorker implements Workable,Eatable{
    @Override
    public void eat() {
        System.out.println("Human eating");
    }

    @Override
    public void work() {
        System.out.println("Human working");
    }
}
