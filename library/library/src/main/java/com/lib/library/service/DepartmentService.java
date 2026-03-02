package com.lib.library.service;

import com.lib.library.entity.Department;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    List<Department> findAll();

    Department update(int deptNo, Department department);

    void delete(int deptNo);

    List<Department> findBydName(String dName);
}
