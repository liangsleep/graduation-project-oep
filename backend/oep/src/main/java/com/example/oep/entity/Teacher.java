package com.example.oep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {
    @Id
    private String teacherId;
    private String password;

    @Column(unique = true)
    private String authCode;
    private Integer status; // 0待审核，1已审核
}
