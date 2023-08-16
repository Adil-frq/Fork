package com.myt.util;

import com.myt.entity.EmployeeEntity;
import com.myt.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Convertor {
    public static Employee entityToModel(EmployeeEntity entity) {
        Employee employee = new Employee();
        employee.setEmpID(entity.getEmpId());
        employee.setEmpFirstName(entity.getEmpFirstName());
        employee.setEmpLastName(entity.getEmpLastName());
        employee.setEmpEmail(entity.getEmpEmail());
        employee.setSalary(entity.getSalary());
        employee.setDateOfJoining(entity.getDateOfJoining());
        return employee;
    }

    public static EmployeeEntity modelToEntity(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmpId(employee.getEmpID());
        entity.setEmpFirstName(employee.getEmpFirstName());
        entity.setEmpLastName(employee.getEmpLastName());
        entity.setEmpEmail(employee.getEmpEmail());
        entity.setSalary(employee.getSalary());
        entity.setDateOfJoining(employee.getDateOfJoining());
        return entity;
    }

    public static List<Employee> entityToModel(List<EmployeeEntity> employeeEntities) {
        List<Employee> employees = employeeEntities.stream()
                .map(e -> entityToModel(e))
                .collect(Collectors.toList());
        return employees;
    }
}
