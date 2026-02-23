package com.per.person.controller;

import com.per.person.entity.Person;

public class TestController {

    public static void main(String[] args) {
        Person p = new Person();
        p.getCity();
        p.setCity("Jalgaon");
        Person person = new Person(1001, "Varsha", "Kanpur");

        System.out.println(person.getCity());
        System.out.println(p.getCity());
    }
}
