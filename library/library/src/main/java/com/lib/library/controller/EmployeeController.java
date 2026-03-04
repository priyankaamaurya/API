package com.lib.library.controller;

import com.lib.library.entity.Employeee;
import com.lib.library.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<Employeee> save(@RequestBody Employeee employeee){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(employeee));
    }

    @GetMapping
    public ResponseEntity<List<Employeee>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PostMapping("/{empNo}")
    public ResponseEntity<Employeee> update(@PathVariable Integer empNo, @RequestBody Employeee employeee){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.update(empNo, employeee));
    }

    @DeleteMapping("/{empNo}")
    public ResponseEntity<String> delete(@PathVariable Integer empNo){
        service.delete(empNo);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Employee details deleted successfully");
    }

    @GetMapping("/find/{EName}")
    public ResponseEntity<List<Employeee>> findByEName(@PathVariable String EName){
        return ResponseEntity.ok(service.findByEName(EName));
    }
}
