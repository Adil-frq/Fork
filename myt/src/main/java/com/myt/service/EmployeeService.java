package com.myt.service;

import com.myt.entity.EmployeeEntity;
import com.myt.exception.EmployeeException;
import com.myt.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee) throws EmployeeException;
    public Employee updateEmployeeById(Employee employee, Long id) throws EmployeeException;
    public Employee getEmployeeById(Long id) throws EmployeeException;

    public List<Employee> getAllEmployee() throws EmployeeException;
    public void deleteEmployeeById(Long id) throws EmployeeException;
    public List<Employee> getEmployeeByFirstName(String name);

    List<EmployeeEntity> getEmployeePagination(Integer pageNumber, Integer pageSize);
}
