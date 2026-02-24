package com.pay.payment.controller;

import com.pay.payment.entity.Payment;

public class TestController {

    public static void main(String[] args) {

        Payment pay = new Payment();
        pay.getPayId();
        pay.setPaymentMode("Offline");

        Payment payment = new Payment(1222331, 8597364577364l, "online");

        System.out.println(pay.getPaymentMode());
        System.out.println(payment.getPayId());
    }
}
