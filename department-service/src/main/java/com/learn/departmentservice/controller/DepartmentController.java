package com.learn.departmentservice.controller;

import com.learn.departmentservice.DepartmentDto;
import com.learn.departmentservice.service.Impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED );
    }

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable String departmentCode){
        DepartmentDto departmentDto = departmentService.getByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @PostMapping("/postTest")
    public ResponseEntity<String> postTest(){
        return new ResponseEntity<>("Employee service", HttpStatus.OK);
    }
}

