package com.pay.payment.controller;

import com.pay.payment.entity.Payment;
import com.pay.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping("/save")
    public Payment save(@RequestBody Payment payment){
        return service.savePayment(payment);
    }

    @GetMapping("/all")
    public List<Payment> findAllPayment(){
        return service.findAll();
    }

    @GetMapping("/{payId}")
    public Payment findPaymentById(@PathVariable int payId){
        return service.findById(payId);
    }

    @PutMapping("/update/{payId}")
    public Payment updateTeacher(@PathVariable int payId, @RequestBody Payment payment){
        return service.updatePayment(payId, payment);
    }

    @DeleteMapping("/delete/{payId}")
    public String deletePayment(@PathVariable int payId){
        service.deletePayment(payId);
        return "Payment deleted successfully";
    }
}
