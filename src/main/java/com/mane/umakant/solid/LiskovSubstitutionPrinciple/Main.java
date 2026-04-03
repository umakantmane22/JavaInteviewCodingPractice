package com.mane.umakant.solid.LiskovSubstitutionPrinciple;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 10);
        Shape square=new Square(5);
        System.out.println(rect.getArea());
        System.out.println(square.getArea());
    }
}
