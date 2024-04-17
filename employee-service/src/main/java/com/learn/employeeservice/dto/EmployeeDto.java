package com.learn.employeeservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Pattern(regexp = ".+@gmail\\.com$", message = "Please provide the valid email address")
    @Email(message = "Please provide the valid email address")
    private String email;
    @NotBlank(message = "Department Code must not be blank")
    @NotNull(message = "Department Code must not be null")
    private String departmentCode;
}
