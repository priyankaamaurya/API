package com.doc.doctor.service.impl;

import com.doc.doctor.entity.Doctor;
import com.doc.doctor.repository.DoctorRepository;
import com.doc.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(int id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found "));
    }

    @Override
    public Doctor updateDoctor(int id, Doctor doctor) {
        Doctor doctor1 = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found "));

        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found "));

        doctorRepository.delete(doctor);
    }


}
