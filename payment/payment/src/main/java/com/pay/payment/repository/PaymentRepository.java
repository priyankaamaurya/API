package com.pay.payment.repository;

import com.pay.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select p from Payment p where p.paymentMode=?1")
    List<Payment> findByPaymentMode(String paymentMode);

    boolean existsByPaymentMode(String paymentMode);
}
