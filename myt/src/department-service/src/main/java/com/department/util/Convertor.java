package com.department.util;

import com.department.entity.DepartmentEntity;
import com.department.model.Department;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    public static DepartmentEntity modelToEntity(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentId(department.getDepartmentId());
        departmentEntity.setDepartmentName(department.getDepartmentName());
        departmentEntity.setDepartmentLocation(department.getDepartmentLocation());
        departmentEntity.setDepartmentHead(department.getDepartmentHead());

        return departmentEntity;
    }

    public static Department entityToModel(DepartmentEntity departmentEntity) {
        Department department = new Department();
        department.setDepartmentId(departmentEntity.getDepartmentId());
        department.setDepartmentName(departmentEntity.getDepartmentName());
        department.setDepartmentLocation(departmentEntity.getDepartmentLocation());
        department.setDepartmentHead(departmentEntity.getDepartmentHead());
        return department;
    }

    public static List<Department> entityToModel(List<DepartmentEntity> departments) {
        return departments.stream()
                .map(d->entityToModel(d))
                .collect(Collectors.toList());
    }


}
