package com.department.entity;

import com.department.constant.ValidationConstant;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="DEPARTMENT")
@Data
@Valid
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="DEPARTMENT_ID")
    private Long departmentId;
    @Column(name ="DEPARTMENT_NAME")
    @NotNull(message = ValidationConstant.DEPARTMENT_NAME_NULL)
    @Size(min = 3, max = 40 , message = ValidationConstant.DEPARTMENT_NAME_LENGTH)
    private String departmentName;
    @Column(name ="DEPARTMENT_LOCATION")
    private String departmentLocation;

    @Column(name = "DEPARTMENT_HEAD")
    private String departmentHead;
}
