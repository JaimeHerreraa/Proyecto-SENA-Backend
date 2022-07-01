package com.sena.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    private Long id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String job;

    @Column
    private Long phone;

    @Column
    private int salary;
}
