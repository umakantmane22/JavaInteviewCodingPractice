package com.mane.umakant.solid.openClosedPrinciple;

//Step 3 — Service using abstraction
public class PaymentService {
    public void processPayment(Payment payment){
        payment.pay();
    }
}
