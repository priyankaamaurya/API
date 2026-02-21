package com.jsp.student.crud.service.impl;

import com.jsp.student.crud.entity.Student;
import com.jsp.student.crud.repository.StudentRepository;
import com.jsp.student.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent (Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // UPDATE METHOD
    @Override
    public Student updateStudent(Integer rol, Student student) {

        Student existingStudent = studentRepository.findById(rol)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + rol));

        // Update fields
        existingStudent.setName(student.getName());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setEmail(student.getEmail());

        // Save updated data
        return studentRepository.save(existingStudent);
    }


    // FIND BY ID IMPLEMENTATION
    @Override
    public Student findById(Integer rol) {
        return studentRepository.findById(rol)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + rol));
    }

    // DELETE METHOD
    @Override
    public void deleteStudent(Integer rol) {

        if (!studentRepository.existsById(rol)) {
            throw new RuntimeException("Student not found with id " + rol);
        }

        studentRepository.deleteById(rol);
    }


}
