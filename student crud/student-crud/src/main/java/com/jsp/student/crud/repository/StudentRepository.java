package com.jsp.student.crud.repository;

import com.jsp.student.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select s from Student s where s.email=?1")
    List<Student> findByEmail(String email);

    boolean existsByEmail(String email);
    List<Student> findByEmailAndPhone(String email, long phone);


}
