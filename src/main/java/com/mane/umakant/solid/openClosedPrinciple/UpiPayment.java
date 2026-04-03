package com.mane.umakant.solid.openClosedPrinciple;

//Step 2 — Create implementations
public class UpiPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("UPI Payment Processing");
    }
}
