package com.sena.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private int id;

    @Column
    private String email;

    @Column
    private String password;

}
