package com.lib.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employeee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empNo;
    private String eName;
    private String job;
    private int mgr;
    private LocalDate hireDate;
    private int sal;
    private int comm;

    @JoinColumn
    @ManyToOne
    private Department deptNo;


}
