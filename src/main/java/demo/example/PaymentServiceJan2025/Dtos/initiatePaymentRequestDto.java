package demo.example.PaymentServiceJan2025.Dtos;

import lombok.Getter;
import lombok.Setter;


public class initiatePaymentRequestDto {
    private Long orderId;
    private Long amount;
    private String phoneNumber;

    public Long getOrderId() {
        return orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
