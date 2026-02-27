package com.emp.employee.controller;

import com.emp.employee.entity.Employee;
import com.emp.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @Operation(summary = "object created of employeee")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "204", description = "invalid data")

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveEmployee(employee));
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployee(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int empId){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(empId));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee employee){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateEmployee(empId, employee));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
        service.deleteEmployee(empId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Employee deleted successfully");
    }

    @GetMapping("/find/{empName}")
    public ResponseEntity<List<Employee>> findByEmpName(@PathVariable String empName){
        return ResponseEntity.ok(service.findByEmpName(empName));
    }
}
