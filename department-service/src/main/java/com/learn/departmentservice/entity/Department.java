package com.learn.departmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
