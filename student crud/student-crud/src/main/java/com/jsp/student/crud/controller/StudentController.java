package com.jsp.student.crud.controller;

import com.jsp.student.crud.entity.Student;
import com.jsp.student.crud.repository.StudentRepository;
import com.jsp.student.crud.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    //Save student (create)
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    //Get all students (Read)
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.findAll();
    }

    // UPDATE
    @PutMapping("/update/{rol}")
    public Student updateStudent(@PathVariable int rol,
                                 @RequestBody Student student) {
        return service.updateStudent(rol, student);
    }

    // DELETE
    @DeleteMapping("/delete/{rol}")
    public String deleteStudent(@PathVariable Integer rol) {
        service.deleteStudent(rol);
        return "Student deleted successfully with id: " + rol;
    }
}
