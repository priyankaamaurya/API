package com.teach.teacher.controller;

import com.teach.teacher.entity.Teacher;
import com.teach.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;


    @PostMapping("/save")
    public Teacher save(@RequestBody Teacher teacher){
        return service.saveTeacher(teacher);
    }

    @GetMapping("/all")
    public List<Teacher> findAllTeacher(){
        return service.findAll();
    }

    @GetMapping("/{tId}")
    public Teacher findTeacherById(@PathVariable int tId){
        return service.findById(tId);
    }

    @PutMapping("/update/{tId}")
    public Teacher updateTeacher(@PathVariable int tId, @RequestBody Teacher teacher){
        return service.updateTeacher(tId, teacher);
    }

    @DeleteMapping("/delete/{tId}")
    public String deleteTeacher(@PathVariable int tId){
        service.deleteTeacher(tId);
        return "Teacher deleted successfully";
    }

}
