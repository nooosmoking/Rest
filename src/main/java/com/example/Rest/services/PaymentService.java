package com.example.Rest.services;

import com.example.Rest.exceptions.NoSuchAccountException;
import com.example.Rest.exceptions.NotEnoughMoneyException;
import com.example.Rest.models.Payment;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScope
@Data
@Service
public class PaymentService {
    private final List<Payment> payments = new LinkedList<>();
    private int balance = 1000;

    public PaymentService() {
        payments.add(new Payment(100, "Anna"));
        payments.add(new Payment(200, "Andrey"));
    }

    public Payment findById(int id) throws NoSuchElementException {
        try {
            return payments.stream().filter(p -> p.getId() == id).findFirst().get();
        } catch (NoSuchElementException ex) {
            throw new NoSuchAccountException("There`s no account with id " + id);
        }
    }

    public void makePayment(Payment payment) throws NotEnoughMoneyException {
        if (balance < payment.getAmount()) {
            throw new NotEnoughMoneyException("Not enough money to make transaction (balance: " + balance + ")");
        }
        balance -= payment.getAmount();
        payments.add(payment);
    }
}
