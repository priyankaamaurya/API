package com.emp.employee.service;

import com.emp.employee.entity.Employee;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> findAll();

    Employee findById(int empId);

    Employee updateEmployee(int empId, Employee employee);

    void deleteEmployee(int empId);

    List<Employee> findByEmpName(String empName);
}
