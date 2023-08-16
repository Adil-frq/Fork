package com.myt.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {
    private Long empID;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private double salary;
    private Date dateOfJoining;
}
