package com.learn.departmentservice;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
