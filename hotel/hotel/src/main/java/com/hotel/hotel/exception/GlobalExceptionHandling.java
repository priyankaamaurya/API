package com.hotel.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(HotelException.class)
    public ResponseEntity<String> handleHotelException(HotelException h){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(h.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception h){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(h.getMessage());
    }

}
