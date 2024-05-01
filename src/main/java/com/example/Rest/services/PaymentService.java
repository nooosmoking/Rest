package com.example.Rest.services;

import com.example.Rest.exceptions.NotEnoughMoneyException;
import com.example.Rest.models.Payment;
import lombok.Data;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.LinkedList;
import java.util.List;

@ApplicationScope
@Data
public class PaymentService {
    private final List<Payment> payments = new LinkedList<>();
    private int balance;

    public void makePayment(Payment payment) throws NotEnoughMoneyException{
        if (balance< payment.getAmount()){
            throw new NotEnoughMoneyException("Not enough money to make transaction (balance: " + balance + ")");
        }
        balance -= payment.getAmount();
        payments.add(payment);
    }
}
