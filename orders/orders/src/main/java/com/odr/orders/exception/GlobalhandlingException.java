package com.odr.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalhandlingException {

    @ExceptionHandler(OrdersException.class)
    public ResponseEntity<String> handleOrdersException(OrdersException o){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(o.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception o){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(o.getMessage());
    }

}
