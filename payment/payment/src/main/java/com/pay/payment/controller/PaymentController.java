package com.pay.payment.controller;

import com.pay.payment.entity.Payment;
import com.pay.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @Operation(summary = "create object of payment")
    @ApiResponse(responseCode ="201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "invalid data")

    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody Payment payment){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.savePayment(payment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> findAllPayment(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

    @GetMapping
    public ResponseEntity<Payment> findPaymentById(@PathVariable int payId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(payId));
    }

    @PutMapping
    public ResponseEntity<Payment> updateTeacher(@PathVariable int payId, @RequestBody Payment payment){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePayment(payId, payment));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePayment(@PathVariable int payId){
        service.deletePayment(payId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Payment deleted successfully");
    }

    @GetMapping("/find/{paymentMode}")
    public ResponseEntity<List<Payment>> findByPaymentMode(@PathVariable String paymentMode){
        return ResponseEntity.ok(service.findByPaymentMode(paymentMode));
    }
}
