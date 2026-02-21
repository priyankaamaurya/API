package com.jsp.student.crud.controller;

import com.jsp.student.crud.entity.Student;
import com.jsp.student.crud.repository.StudentRepository;
import com.jsp.student.crud.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    // CREATE
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{rol}")
    public Student getStudentById(@PathVariable int rol) {
        return service.findById(rol);
    }

    // UPDATE
    @PutMapping("/update/{rol}")
    public Student updateStudent(@PathVariable int rol, @RequestBody Student student) {
        return service.updateStudent(rol, student);
    }

    // DELETE
    @DeleteMapping("/delete/{rol}")
    public String deleteStudent(@PathVariable int rol) {
        service.deleteStudent(rol);
        return "Student deleted successfully with id: " + rol;
    }
}
