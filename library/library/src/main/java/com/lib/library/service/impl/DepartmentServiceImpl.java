package com.lib.library.service.impl;

import com.lib.library.entity.Department;
import com.lib.library.exception.DepartmentException;
import com.lib.library.repository.DepartmentRepository;
import com.lib.library.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        if (departmentRepository.existsBydName(department.getDName()))
            throw new DepartmentException("department name already exist");
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }


    @Override
    public Department update(int deptNo, Department department) {
        Department department1 =departmentRepository.findById(deptNo)
                .orElseThrow(()-> new RuntimeException("Department not found"));
        department1.setDName(department.getDName());
        department1.setLoc(department.getLoc());

        return departmentRepository.save(department1);
    }

    @Override
    public void delete(int deptNo) {
        Department department = departmentRepository.findById(deptNo)
                .orElseThrow(() -> new RuntimeException("Department not found "));

        departmentRepository.delete(department);
    }

    @Override
    public List<Department> findBydName(String dName) {
        return departmentRepository.findBydName(dName);
    }

}
