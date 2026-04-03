package com.mane.umakant.solid.openClosedPrinciple;

//Step 2 — Create implementations
public class PaypalPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Paypal Payment Processing");
    }
}
