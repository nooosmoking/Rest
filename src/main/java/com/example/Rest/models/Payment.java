package com.example.Rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Payment {
    private int amount;
    private String receiver;
}
