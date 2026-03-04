package com.lib.library.service.impl;

import com.lib.library.entity.Employeee;
import com.lib.library.exception.DepartmentException;
import com.lib.library.exception.EmployeeException;
import com.lib.library.repository.EmployeeRepository;
import com.lib.library.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employeee save(Employeee employeee) {
        if (employeeRepository.existsByEName(employeee.getEName()))
            throw new EmployeeException("Employee name already exist");
        return employeeRepository.save(employeee);
    }

    @Override
    public List<Employeee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employeee update(int empNo, Employeee employeee) {
        Employeee employeee1 = employeeRepository.findById(empNo)
                .orElseThrow(()-> new RuntimeException("Employee not found"));
        employeee1.setEName(employeee.getEName());
        employeee1.setJob(employeee.getJob());
        employeee1.setMgr(employeee.getMgr());
        employeee1.setHireDate(employeee.getHireDate());
        employeee1.setSal(employeee.getSal());
        employeee1.setComm(employeee.getComm());
        employeee1.setDeptNo(employeee.getDeptNo());

        return employeeRepository.save(employeee1);
    }

    @Override
    public void delete(int empNo) {
        Employeee employeee = employeeRepository.findById(empNo)
                .orElseThrow(() -> new RuntimeException("Employee not found "));

        employeeRepository.delete(employeee);
    }

    @Override
    public List<Employeee> findByEName(String EName) {
        return employeeRepository.findByEName(EName);
    }


}
