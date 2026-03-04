package com.lib.library.service;

import com.lib.library.entity.Employeee;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface EmployeeService {

    Employeee save(Employeee employeee);

    List<Employeee> findAll();

    Employeee update(Integer empNo, Employeee employeee);

    void delete(Integer empNo);

    List<Employeee> findByEName(String EName);
}
