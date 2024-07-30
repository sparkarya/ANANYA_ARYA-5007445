interface PaymentProcessor {
    void processPayment();
}

class OldPaymentGateway {
    public void makePayment() {
        System.out.println("Payment made via old gateway");
    }
}

class OldPaymentAdapter implements PaymentProcessor {
    private OldPaymentGateway oldPaymentGateway;

    public OldPaymentAdapter(OldPaymentGateway oldPaymentGateway) {
        this.oldPaymentGateway = oldPaymentGateway;
    }

    public void processPayment() {
        oldPaymentGateway.makePayment();
    }
}

class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new OldPaymentAdapter(new OldPaymentGateway());
        processor.processPayment();
    }
}
