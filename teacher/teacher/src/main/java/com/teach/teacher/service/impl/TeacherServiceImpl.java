package com.teach.teacher.service.impl;

import com.teach.teacher.entity.Teacher;
import com.teach.teacher.exception.TeacherException;
import com.teach.teacher.repository.TeacherRepository;
import com.teach.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        if(teacherRepository.existsByTeacherName(teacher.getTeacherName()))
            throw new TeacherException("teacher name is already exist");
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int tId) {
        return teacherRepository.findById(tId)
                .orElseThrow(() -> new RuntimeException("Teacher not found "));
    }

    @Override
    public Teacher updateTeacher(int tId, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findById(tId)
                .orElseThrow(() -> new RuntimeException("Teacher not found "));

        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int tId) {
        Teacher teacher = teacherRepository.findById(tId)
                .orElseThrow(() -> new RuntimeException("Teacher not found "));

        teacherRepository.delete(teacher);
    }

    @Override
    public List<Teacher> findByTeacherName(String teacherName) {
        return teacherRepository.findByTeacherName(teacherName);
    }
}
