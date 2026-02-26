package com.teach.teacher.repository;

import com.teach.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    @Query("select t from Teacher t where t.teacherName=?1")
    List<Teacher> findByTeacherName(String teacherName);
}
