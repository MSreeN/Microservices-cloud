package com.learn.employeeservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String departmentCode;
}
