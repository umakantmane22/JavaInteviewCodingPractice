package com.mane.umakant.solid.InterfaceSegregationPrinciple;

public class Main {
    public static void main(String[] args) {
        Workable human=new HumanWorker();
        human.work();

        Workable robot=new RobotWorker();
        robot.work();
    }
}
