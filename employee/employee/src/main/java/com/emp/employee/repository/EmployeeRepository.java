package com.emp.employee.repository;

import com.emp.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmpName(String empName);

    boolean existsByEmpName(String empName);
}
