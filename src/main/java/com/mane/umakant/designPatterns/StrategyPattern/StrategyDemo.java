package com.mane.umakant.designPatterns.StrategyPattern;

// 1️⃣ Strategy (Interface) e.g Algorithm define करतो
interface PaymentStrategy {
    void pay(int amount);
}

// 2️⃣ Concrete Strategies e.g Actual implementations
class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class UpiPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

//3️⃣ Context e.g. Strategy वापरणारा class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void payAmount(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
 /*       PaymentContext context=new PaymentContext(new CashPayment());
        context.payAmount(100);

        // runtime strategy change
        context.setPaymentStrategy(new CardPayment());
        context.payAmount(200);

        context.setPaymentStrategy(new UpiPayment());
        context.payAmount(300);
*/
        PaymentStrategy cash = amount ->
                System.out.println("Paid " + amount + " using Cash");

        PaymentContext context = new PaymentContext(cash);
        context.payAmount(500);

    }
}
