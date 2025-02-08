package demo.example.PaymentServiceJan2025.paymentGatways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("RazorPaymentGateway")
public class RazorpayPaymentGateway implements PaymentGateway {
    RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(Long order_id, Long amount, String phoneNumber) throws RazorpayException {
    // While calling the generatePaymentLink always create a new instance to leave that we can mention in config.
//        RazorpayClient instance = new RazorpayClient("rzp_test_KBLiRYEEOqLHkZ", "lBwDvCRli2u2LmUaFQwXEllm");

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000); // This is 10.00 RS
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 10 * 60 * 1000); // 10 Min
        paymentLinkRequest.put("reference_id", order_id);
        paymentLinkRequest.put("description","Payment for buying a biscuit");

        // You can call your order service using Rest template and get the user data
        JSONObject customer = new JSONObject();
        customer.put("name","MSK Karan");
        customer.put("contact","+919098991174");
        customer.put("email","mansingh.karan007@gmail.com");

        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
