package com.teach.teacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(TeacherException.class)
    public ResponseEntity<String> handleTeacherException(TeacherException t){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception t){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t.getMessage());
    }

}
