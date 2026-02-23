package com.emp.employee.controller;

import com.emp.employee.entity.Employee;

public class TestController {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setEmpName("Priyanka");
        e.getDept();
        Employee emp = new Employee(101, "Prachi", "Gurgaon", "IT");

        System.out.println(emp.getEmpId());
        System.out.println(e.getEmpName());

    }

}
