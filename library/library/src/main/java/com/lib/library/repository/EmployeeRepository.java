package com.lib.library.repository;

import com.lib.library.entity.Employeee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employeee, Integer> {

    List<Employeee> findByEName(String eName);
}
