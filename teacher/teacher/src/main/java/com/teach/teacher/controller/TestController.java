package com.teach.teacher.controller;

import com.teach.teacher.entity.Teacher;

public class TestController {

    public static void main(String[] args) {

        Teacher t = new Teacher();
        t.getTId();
        t.setTeacherName("Prachi");
        Teacher teach = new Teacher(1221, "Priya");

        System.out.println(t.getTeacherName());
        System.out.println(teach.getTId());
    }


}
