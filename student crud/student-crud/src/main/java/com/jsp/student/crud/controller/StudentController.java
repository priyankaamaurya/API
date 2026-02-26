package com.jsp.student.crud.controller;

import com.jsp.student.crud.entity.Student;
import com.jsp.student.crud.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @Operation(summary = "create object of student")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "Invalid data")
    // CREATE
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveStudent(student));
    }

    // READ ALL
    @GetMapping("/find")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

    // READ BY ID
    @GetMapping
    public ResponseEntity<Student> getStudentById(@PathVariable int rol) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(rol));
    }

    // UPDATE
    @PutMapping
    public ResponseEntity<Student> updateStudent(@PathVariable int rol, @RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateStudent(rol, student));
    }

    // DELETE
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@PathVariable int rol) {
        service.deleteStudent(rol);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Student deleted successfully");
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<List<Student>> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(service.findByEmail(email));
    }
}
