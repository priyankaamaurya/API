package com.student.crud.controller;

import com.student.crud.entity.Student;
import com.student.crud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class TestController {

    @Autowired
    private StudentRepo StudentRepo;

    // CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return StudentRepo.save(student);
    }

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return StudentRepo.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return (Student) StudentRepo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student) {
        student.setId(id);
        return StudentRepo.save(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        StudentRepo.deleteById(id);
    }

    // FILTER BY COURSE
    @GetMapping("/course")
    public List<Student> filterByCourse(
            @RequestParam String course) {
        return StudentRepo.findByCourse(course);
    }

    // SEARCH WITH MULTIPLE FILTERS
    @GetMapping("/search")
    public List<Student> search(
            @RequestParam String name,
            @RequestParam String course) {
        return StudentRepo.findByNameAndCourse(name, course);
    }
}

