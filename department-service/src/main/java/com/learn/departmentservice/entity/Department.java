package com.learn.departmentservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    @NotNull
    private String departmentName;
    @NotBlank
    @NotNull
    private String departmentDescription;

    @NotNull
    @NotBlank
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.
    )
    private String departmentCode;
}
