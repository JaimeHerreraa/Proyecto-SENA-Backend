package com.sena.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String info;

    @Column
    private int cost;

    @Column
    private String state;

    @Column
    private Date task_date;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
