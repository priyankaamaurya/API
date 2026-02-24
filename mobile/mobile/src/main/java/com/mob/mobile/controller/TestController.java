package com.mob.mobile.controller;

import com.mob.mobile.entity.Mobile;

public class TestController {

    public static void main(String[] args) {

        Mobile m = new Mobile();
        m.setId(101);

        Mobile mob = new Mobile(1001, "Samsung", "Galaxy M23");

        System.out.println(m.getId());
        System.out.println(mob.getModel());


    }
}
