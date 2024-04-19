package com.learn.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@Entity
//@NoArgsConstructor
//@Table(name = "employees")
public class Employee {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
//    @Email(message = "Please provide valid email")
    private String email;
    private String departmentCode;
}
