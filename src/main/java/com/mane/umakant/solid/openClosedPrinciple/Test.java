package com.mane.umakant.solid.openClosedPrinciple;

public class Test {
    public static void main(String[] args) {
        PaymentService paymentService=new PaymentService();
        Payment creditCard=new CreditCardPayment();
        paymentService.processPayment(creditCard);

        Payment upi=new UpiPayment();
        paymentService.processPayment(upi);

        // 6️⃣ Add New Payment Method (No Code Modification)
        Payment crypto = new CryptoPayment();
        paymentService.processPayment(crypto);


    }
}
