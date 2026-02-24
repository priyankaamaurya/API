package com.doc.doctor.controller;

import com.doc.doctor.entity.Doctor;

public class TestController {

    public static void main(String[] args) {

        Doctor d = new Doctor();
        d.setId(101);

        Doctor doc = new Doctor(102, "Priyanka Maurya", "Cardiologist");

        System.out.println(d.getId());
        System.out.println(doc.getSpecialization());

    }
}
