package com.learn.employeeservice.service.impl;

import com.learn.employeeservice.EmployeeServiceApplication;
import com.learn.employeeservice.dto.EmployeeDto;
import com.learn.employeeservice.entity.Employee;
import com.learn.employeeservice.exceptions.ResourceNotFoundException;
import com.learn.employeeservice.repository.EmployeeRepository;
import com.learn.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
//        EmployeeDto employeeDto1 = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );
        EmployeeDto employeeDto1 = modelMapper.map(savedEmployee, EmployeeDto.class);
        return employeeDto1;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employee1 = employee.orElseThrow(() -> new ResourceNotFoundException("No employee with " +
                "id "+ id));
        return  modelMapper.map(employee1, EmployeeDto.class);

    }
}
