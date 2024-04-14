package com.learn.employeeservice.service;

import com.learn.employeeservice.dto.EmployeeDto;
import com.learn.employeeservice.exceptions.ResourceNotFoundException;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(Long id) throws ResourceNotFoundException;
}
