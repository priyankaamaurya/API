package com.hotel.hotel.controller;

import com.hotel.hotel.entity.Hotel;

public class TestController {

    public static void main(String[] args) {
        Hotel h = new Hotel();
        h.setId(1);

        Hotel hotel = new Hotel(101, "Taj Hotel", "Gurgaon");

        System.out.println(h.getId());
        System.out.println(hotel.getHotelName());
    }
}
