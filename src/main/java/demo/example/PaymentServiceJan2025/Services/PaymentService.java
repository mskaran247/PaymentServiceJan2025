package demo.example.PaymentServiceJan2025.Services;

import com.razorpay.RazorpayException;
import demo.example.PaymentServiceJan2025.paymentGatways.PaymentGateway;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class PaymentService{
    private PaymentGateway paymentGateway;

    // Dependency injection
    public PaymentService(@Qualifier("RazorPaymentGateway") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, Long amount, String phoneNumber) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId, amount, phoneNumber);
    }

}
