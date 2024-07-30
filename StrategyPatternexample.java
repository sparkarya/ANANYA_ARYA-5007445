interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment() {
        strategy.pay();
    }
}

class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new PayPalPayment());
        context.executePayment();

        context = new PaymentContext(new CreditCardPayment());
        context.executePayment();
    }
}
