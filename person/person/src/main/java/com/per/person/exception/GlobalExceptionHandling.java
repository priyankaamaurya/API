package com.per.person.exception;

import com.per.person.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(PersonException.class)
    public ResponseEntity<String> handlePersonException(PersonException p){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(p.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception p){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(p.getMessage());
    }
}
