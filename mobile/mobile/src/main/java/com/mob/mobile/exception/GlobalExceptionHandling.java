package com.mob.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(MobileException.class)
    public ResponseEntity<String> handleMobileException(MobileException m){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception m){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m.getMessage());
    }

}
