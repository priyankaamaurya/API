package com.pay.payment.service.impl;

import com.pay.payment.entity.Payment;
import com.pay.payment.repository.PaymentRepository;
import com.pay.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(int payId) {
        return paymentRepository.findById(payId)
                .orElseThrow(() -> new RuntimeException("Payment not found "));
    }

    @Override
    public Payment updatePayment(int payId, Payment payment) {
        Payment payment1 = paymentRepository.findById(payId)
                .orElseThrow(() -> new RuntimeException("Payment not found "));

        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(int payId) {
        Payment payment = paymentRepository.findById(payId)
                .orElseThrow(() -> new RuntimeException("Payment not found "));

        paymentRepository.delete(payment);

    }


}
