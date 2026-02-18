package com.student.crud.repository;

import com.student.crud.entity.Student;

import java.lang.ScopedValue;
import java.util.List;

public interface StudentRepo
        extends Student<Student, Long> {

    List<Student> findByCourse(String course);

    List<Student> findByNameAndCourse(String name, String course);

    void deleteById(Long id);

    Student save(Student student);

    ScopedValue<Object> findById(Long id);
}

