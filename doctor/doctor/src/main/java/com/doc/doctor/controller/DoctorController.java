package com.doc.doctor.controller;

import com.doc.doctor.entity.Doctor;
import com.doc.doctor.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @Operation(summary = "object created of doctor")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "204", description = "invalid data")

    @PostMapping
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveDoctor(doctor));
    }

    @GetMapping("/all")
    public List<Doctor> findAllDoctor(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Doctor> findDoctorById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateDoctor(id, doctor));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDoctor(@PathVariable int id){
        service.deleteDoctor(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Doctor deleted successfully");
    }

}
