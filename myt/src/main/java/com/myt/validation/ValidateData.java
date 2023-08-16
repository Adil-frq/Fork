package com.myt.validation;

import com.myt.constant.ErrorMessage;
import com.myt.exception.EmployeeException;
import com.myt.model.Employee;

public class ValidateData {
    public void validate(Employee employee) {
        if(employee.getEmpFirstName().length() <  3 || employee.getEmpFirstName().length() > 40)
            throw new EmployeeException(ErrorMessage.Employee_NAME_LENGTH);
    }
}
