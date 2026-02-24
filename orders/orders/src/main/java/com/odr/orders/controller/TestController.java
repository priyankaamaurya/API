package com.odr.orders.controller;

import com.odr.orders.entity.Orders;

public class TestController {

    public static void main(String[] args) {

        Orders o = new Orders();
        o.setId(1);

        Orders od = new Orders(101, "SmartWatch", "Received");

        System.out.println(o.getId());
        System.out.println(od.getStatus());

    }
}
