package com.department.validation;

import com.department.constant.ValidationConstant;
import com.department.exception.DepartmentException;
import com.department.model.Department;


public class ValidateData {
    public static void validate(Department department) {
        if(department.getDepartmentName() == null)
            throw new DepartmentException(ValidationConstant.DEPARTMENT_NAME_NULL);
        if(department.getDepartmentName().length() < 3 && department.getDepartmentName().length() > 40)
            throw new DepartmentException(ValidationConstant.DEPARTMENT_NAME_LENGTH);



    }
}
