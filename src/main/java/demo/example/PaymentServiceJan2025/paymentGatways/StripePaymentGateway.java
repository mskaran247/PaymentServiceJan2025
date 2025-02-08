package demo.example.PaymentServiceJan2025.paymentGatways;


import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long order_id, Long amount, String phoneNumber) {
        return null;
    }
}
