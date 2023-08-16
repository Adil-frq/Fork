package com.department.model;

import com.department.constant.ValidationConstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Department {
    private Long departmentId;
    private String departmentName;
    private String departmentLocation;
    private String departmentHead;

}
