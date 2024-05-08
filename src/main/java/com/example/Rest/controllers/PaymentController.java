package com.example.Rest.controllers;

import com.example.Rest.models.Payment;
import com.example.Rest.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> paymentsGet(){
        return paymentService.getPayments();
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> paymentsByIdGet(@PathVariable int id){
        Payment payment = paymentService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(payment);
    }

    @GetMapping("/balance")
    public int balanceGet(){
        return paymentService.getBalance();
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
        paymentService.makePayment(payment);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(payment);
    }

    @PutMapping("/payments")
    public ResponseEntity<Payment> changePayment(@RequestBody Payment payment){
        paymentService.changePayment(payment);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(payment);
    }


    @DeleteMapping("/payments/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable int id){
        paymentService.deletePayment(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
