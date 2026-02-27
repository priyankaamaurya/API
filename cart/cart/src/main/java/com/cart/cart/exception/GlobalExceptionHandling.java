package com.cart.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandling {

    @ExceptionHandler(CartException.class)
    public ResponseEntity<String> handleDoctorException(CartException d){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(d.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception d){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(d.getMessage());
    }

}
