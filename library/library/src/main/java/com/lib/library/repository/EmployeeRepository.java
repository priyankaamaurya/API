package com.lib.library.repository;

import com.lib.library.entity.Employeee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employeee, Integer> {
}
