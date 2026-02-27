package com.doc.doctor.service;

import com.doc.doctor.entity.Doctor;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);

    List<Doctor> findAll();

    Doctor findById(int id);

    Doctor updateDoctor(int id, Doctor doctor);

    void deleteDoctor(int id);

    List<Doctor> findByName(String name);
}
