package com.example.Rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Payment {
    private int amount;
    private String receiver;
    private int id;

    public Payment(int amount, String receiver) {
        this.amount = amount;
        this.receiver = receiver;
        this.id = PaymentIdsGenerator.getInstance().generateId();
    }
}
