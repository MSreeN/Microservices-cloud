package com.learn.employeeservice.controller;

import com.learn.employeeservice.dto.ApiResponseDto;
import com.learn.employeeservice.dto.EmployeeDto;
import com.learn.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getByEmployeeId(@PathVariable Long id)throws Exception{
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
