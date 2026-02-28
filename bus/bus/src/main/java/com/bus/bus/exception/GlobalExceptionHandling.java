package com.bus.bus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(BusException.class)
    public ResponseEntity<String> handleBusException(BusException b){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception b){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b.getMessage());
    }
}
