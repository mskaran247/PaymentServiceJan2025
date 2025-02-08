package demo.example.PaymentServiceJan2025.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
//    @Value("${razorpay.key.id}")
//    private String razorpayKeyId;

//    @Value("${razorpay.key.value}")
//    private String razorpayKeyValue;

    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient("rzp_test_KBLiRYEEOqLHkZ", "lBwDvCRli2u2LmUaFQwXEllm");
    }

}
