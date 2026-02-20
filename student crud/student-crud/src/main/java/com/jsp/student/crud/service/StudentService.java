package com.jsp.student.crud.service;

import com.jsp.student.crud.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent (Student student);

    List<Student> findAll ();

    Student updateStudent(Integer rol, Student student);

    Student findById(Integer rol);

    void deleteStudent(Integer rol);
}
