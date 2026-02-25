package com.teach.teacher.controller;

import com.teach.teacher.entity.Teacher;
import com.teach.teacher.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @Operation(summary = "create object of student")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "Invalid data")

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body (service.saveTeacher(teacher));
    }

    @GetMapping("/all")
    public List<Teacher> findAllTeacher(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Teacher> findTeacherById(@PathVariable int tId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(tId));
    }

    @PutMapping
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int tId, @RequestBody Teacher teacher){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateTeacher(tId, teacher));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTeacher(@PathVariable int tId){
        service.deleteTeacher(tId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Teacher deleted successfully");
    }

}
