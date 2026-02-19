package com.jsp.student.crud.controller;

import com.jsp.student.crud.entity.Student;

public class TestController {

    public static void main(String[] args) {
        Student s = new Student();
        s.getEmail();
        s.setName("priyanka");
        Student s1 = new Student(101,"Priyanka", 9865773734l, "pr88@gmail.com");

        System.out.println(s.getName());
        System.out.println(s1.getEmail());
    }
}
