package com.department.service;

import com.department.entity.DepartmentEntity;
import com.department.exception.DepartmentException;
import com.department.model.Department;

import java.util.List;

public interface DepartmentService {

    public Department addDepartment(Department department) throws DepartmentException;
    public List<Department> getAllDepartment() throws DepartmentException;

    public Department getDepartmentById(Long id) throws DepartmentException;

    public List<Department> getDepartmentByName(String deptName) throws DepartmentException;

    public void deleteDepartmentById(Long id) throws DepartmentException;

    public Department updateEmployeeById(Department department, Long id)throws DepartmentException;
    public List<Department> getDepartentPagination(int pageNumber, int pageSize) throws DepartmentException;
}
