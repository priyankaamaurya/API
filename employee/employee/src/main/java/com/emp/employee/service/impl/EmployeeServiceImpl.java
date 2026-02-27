package com.emp.employee.service.impl;

import com.emp.employee.entity.Employee;
import com.emp.employee.exception.EmployeeException;
import com.emp.employee.repository.EmployeeRepository;
import com.emp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employeeRepository.existsByEmpName(employee.getEmpName()))
            throw new EmployeeException("empName is already exist");
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found "));
    }

    @Override
    public Employee updateEmployee(int empId, Employee employee) {
        Employee employee1 = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found "));

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found "));

        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findByEmpName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }


}
