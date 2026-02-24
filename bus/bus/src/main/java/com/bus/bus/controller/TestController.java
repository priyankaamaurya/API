package com.bus.bus.controller;

import com.bus.bus.entity.Bus;

public class TestController {

    public static void main(String[] args) {

        Bus b = new Bus();
        b.setBusName("Voyage Bus");

        Bus bus = new Bus(1001, "Blue bus", "Delhi to Kanpur");
        System.out.println(b.getBusName());
        System.out.println(bus.getDetination());
    }
}
