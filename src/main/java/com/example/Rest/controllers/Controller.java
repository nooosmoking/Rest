package com.example.Rest.controllers;

import com.example.Rest.models.Payment;
import com.example.Rest.services.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {
    private final PaymentService paymentService;

    public Controller(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> paymentsGet(){
        return paymentService.getPayments();
    }

    @GetMapping("/payment")
    public Payment paymentsByIdGet(@RequestParam int id){
        return paymentService.findById(id);
    }

    @GetMapping("/balance")
    public int balanceGet(){
        return paymentService.getBalance();
    }

//    @PostMapping("/login")
//    public String loginPost(@RequestParam String username, @RequestParam String password, Model page){
//
//    }
}
