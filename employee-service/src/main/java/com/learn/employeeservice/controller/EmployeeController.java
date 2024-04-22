package com.learn.employeeservice.controller;

import com.learn.employeeservice.dto.ApiResponseDto;
import com.learn.employeeservice.dto.DepartmentDto;
import com.learn.employeeservice.dto.EmployeeDto;
import com.learn.employeeservice.exceptions.InvalidValidationException;
import com.learn.employeeservice.exceptions.ResourceNotFoundException;
import com.learn.employeeservice.service.ApiClient;
import com.learn.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    ApiClient apiClient;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto,
                                                    Errors errors){
        if(errors.hasErrors()){
            throw new InvalidValidationException(errors.getFieldError().getDefaultMessage());
        }
        try {
//            ResponseEntity<DepartmentDto> departmentResponse = restTemplate.getForEntity("http" +
//                    "://localhost:8082/api" +
//                    "/department/" + employeeDto.getDepartmentCode(), DepartmentDto.class);

//            DepartmentDto departmentResponse =
//                    webClient.get()
//                            .uri("http" +"://localhost:8082/api" +
//                   "/department/" + employeeDto.getDepartmentCode())
//                            .retrieve()
//                            .bodyToMono(DepartmentDto.class)
//                            .block();
            DepartmentDto departmentDto =
                    apiClient.getByDepartmentCode(employeeDto.getDepartmentCode());
        }
        catch(Exception ex){
            throw new ResourceNotFoundException("Department "+employeeDto.getDepartmentCode()+" " +
                    "not found");
        }
//        if(departmentResponse.getStatusCode().equals(HttpStatus.NOT_FOUND)){
//            System.out.println("No department");
//            throw new ResourceNotFoundException("Department "+employeeDto.getDepartmentCode()+" " +
//                    "is not found");
//        }
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getByEmployeeId(@PathVariable Long id)throws Exception{
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
