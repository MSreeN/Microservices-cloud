package com.learn.departmentservice.service.Impl;

import com.learn.departmentservice.DepartmentDto;
import com.learn.departmentservice.entity.Department;
import com.learn.departmentservice.exceptions.ResourceNotFoundException;
import com.learn.departmentservice.repository.DepartmentRepository;
import com.learn.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        System.out.println(departmentDto + "department");
        Department department  = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto departmentDto1 = modelMapper.map(savedDepartment, DepartmentDto.class);

        return departmentDto1;
    }

    @Override
    public DepartmentDto getByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        if(department == null){
            System.out.println(true);
            throw new ResourceNotFoundException("No department with id "+departmentCode);
        }
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }
}
