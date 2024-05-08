package com.example.Rest.controllers.advices;

import com.example.Rest.exceptions.NoSuchAccountException;
import com.example.Rest.exceptions.NotEnoughMoneyException;
import com.example.Rest.models.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> ExceptionNotEnoughMoneyHandler(){
        ErrorDetails errorDetails = new ErrorDetails("User does not have enough funds to complete this transaction.");
        return ResponseEntity.badRequest().body(errorDetails);
    }

    @ExceptionHandler(NoSuchAccountException.class)
    public ResponseEntity<ErrorDetails> ExceptionNoSuchAccountException(NoSuchAccountException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
