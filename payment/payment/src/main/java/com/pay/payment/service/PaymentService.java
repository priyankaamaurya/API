package com.pay.payment.service;

import com.pay.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    
    Payment savePayment(Payment payment);

    List<Payment> findAll();

    Payment findById(int payId);

    Payment updatePayment(int payId, Payment payment);

    void deletePayment(int payId);
}
