package com.lib.library.repository;

import com.lib.library.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findBydName(String dName);

    boolean existsBydName(String dName);
}
