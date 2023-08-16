package com.myt.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEE")
@Valid
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private Long empId;
    @Column(name = "EMP_FIRST_NAME", length = 40)
    @NotNull
    @Size(min=3, max = 40, message="Name should be greater than 3 and less than 40 characters")
    private String empFirstName;
    @Column(name = "EMP_LAST_NAME", length = 40, nullable = false)
    private String empLastName;
    @Column(name = "EMP_EMAIL", unique=true)
    private String empEmail;
    @Column(name ="EMP_SALARY" , nullable = false)
    private Double salary;
    @Column(name = "date_of_joining", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;

}
