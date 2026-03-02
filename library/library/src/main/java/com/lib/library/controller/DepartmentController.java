package com.lib.library.controller;

import com.lib.library.entity.Department;
import com.lib.library.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<Department> save (@RequestBody Department department){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PutMapping("/{deptNo}")
    public ResponseEntity<Department> update(@PathVariable int deptNo, @RequestBody Department department){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.update(deptNo, department));
    }

    @DeleteMapping("/{deptNo}")
    public ResponseEntity<String> delete(@PathVariable int deptNo){
        service.delete(deptNo);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Department deleted successfully");
    }

    @GetMapping("/find/{dName}")
    public ResponseEntity<List<Department>> findBydName(@PathVariable String dName){
        return ResponseEntity.ok(service.findBydName(dName));
    }
}
