package com.student.crud.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TestController {

    private List<Student> students = new ArrayList<>();
    private int idCounter = 1;

    // Create Student
    @PostMapping
    public Student create(@RequestBody Student student){
        student.setId(idCounter++);
        students.add(student);
        return student;
    }

    // Get All Students
    @GetMapping
    public List<Student> getAll() {
        return students;
    }

    // Get Single Student
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        students.removeIf(s -> s.getId() == id);
        return "Student Deleted";
    }

    // Filter by Course
    @GetMapping("/course")
    public List<Student>
    filterByCourse(@RequestParam String course){
        return students.stream()
                .filter(s ->
                s.getCourse().equalsIgnoreCase(course))
                .collect(Collectors.toList());
    }

    // Search with Multiple Filters
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name, @RequestParam String course){
        return students.stream()
                .filter(s ->
                        s.getName().equalsIgnoreCase(name) && s.getCourse().equalsIgnoreCase(course))
                .collect(Collectors.toList());
    }
}
