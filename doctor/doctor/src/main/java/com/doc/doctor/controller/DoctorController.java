package com.doc.doctor.controller;

import com.doc.doctor.entity.Doctor;
import com.doc.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService service;


    @PostMapping("/save")
    public Doctor save(@RequestBody Doctor doctor){
        return service.saveDoctor(doctor);
    }

    @GetMapping("/all")
    public List<Doctor> findAllDoctor(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor doctor){
        return service.updateDoctor(id, doctor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id){
        service.deleteDoctor(id);
        return "Doctor deleted successfully";
    }

}
