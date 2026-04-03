package com.mane.umakant.solid.InterfaceSegregationPrinciple;

public class RobotWorker implements Workable{
    @Override
    public void work() {
        System.out.println("Robot working");
    }
}
