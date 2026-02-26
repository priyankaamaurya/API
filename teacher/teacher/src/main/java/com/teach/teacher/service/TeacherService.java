package com.teach.teacher.service;

import com.teach.teacher.entity.Teacher;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> findAll();

    Teacher findById(int tId);

    Teacher updateTeacher(int tId, Teacher teacher);

    void deleteTeacher(int tId);

    List<Teacher> findByTeacherName(String teacherName);
}
