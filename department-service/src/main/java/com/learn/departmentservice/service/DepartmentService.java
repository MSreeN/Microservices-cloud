package com.learn.departmentservice.service;

import com.learn.departmentservice.DepartmentDto;

public interface DepartmentService {
    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getByDepartmentCode(String departmentCode);
}
