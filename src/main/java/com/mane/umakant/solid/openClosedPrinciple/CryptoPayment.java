package com.mane.umakant.solid.openClosedPrinciple;

//6️⃣ Add New Payment Method (No Code Modification)
public class CryptoPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Crypto Payment Processing");
    }
}
