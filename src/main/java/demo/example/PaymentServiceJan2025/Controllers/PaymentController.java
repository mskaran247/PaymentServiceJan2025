package demo.example.PaymentServiceJan2025.Controllers;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import demo.example.PaymentServiceJan2025.Dtos.initiatePaymentRequestDto;
import demo.example.PaymentServiceJan2025.Services.PaymentService;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public String initiatePayment(@RequestBody initiatePaymentRequestDto initiatePaymentRequestDto) throws RazorpayException {
        return paymentService.initiatePayment(initiatePaymentRequestDto.getOrderId(),
                initiatePaymentRequestDto.getAmount(),initiatePaymentRequestDto.getPhoneNumber());

    }

}
