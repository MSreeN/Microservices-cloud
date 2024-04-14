package com.learn.employeeservice.service;

import com.learn.employeeservice.dto.ApiResponseDto;
import com.learn.employeeservice.dto.EmployeeDto;
import com.learn.employeeservice.exceptions.ResourceNotFoundException;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public ApiResponseDto getEmployeeById(Long id) throws ResourceNotFoundException;
}
