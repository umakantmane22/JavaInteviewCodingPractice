package com.mane.umakant.solid.openClosedPrinciple;

//Step 2 — Create implementations
public class CreditCardPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Credit Card Payment Processing");
    }
}
