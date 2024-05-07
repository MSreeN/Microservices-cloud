package com.learn.employeeservice.service;

import com.learn.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8082", value = "departmentService")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("api/department/{departmentCode}")
    DepartmentDto getByDepartmentCode(@PathVariable String departmentCode);
}
