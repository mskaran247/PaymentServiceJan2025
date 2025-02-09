package demo.example.PaymentServiceJan2025.paymentGatways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {

    public String generatePaymentLink(Long orderId, Long amount, String phoneNumber) throws RazorpayException;
}
