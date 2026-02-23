package com.emp.employee.controller;

import com.emp.employee.entity.Employee;
import com.emp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployee(){
        return service.findAll();
    }

    @GetMapping("/{empId}")
    public Employee findEmployeeById(@PathVariable int empId){
        return service.findById(empId);
    }

    @GetMapping("/update/{empId}")
    public Employee updateEmployee(@PathVariable int empId, @RequestBody Employee employee){
        return service.updateEmployee(empId, employee);
    }

    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        service.deleteEmployee(empId);
        return "Employee deleted successfully";
    }
}
