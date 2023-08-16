package com.myt.service.impl;

import com.myt.entity.EmployeeEntity;
import com.myt.exception.EmployeeException;
import com.myt.model.Employee;
import com.myt.repository.EmployeeRepository;
import com.myt.service.EmployeeService;
import com.myt.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) throws EmployeeException {

        EmployeeEntity entity = Convertor.modelToEntity(employee);
        EmployeeEntity employeeEntity = employeeRepository.save(entity);

        return Convertor.entityToModel(employeeEntity);
    }

    @Override
    public Employee updateEmployeeById(@RequestBody Employee employee, Long empId)throws EmployeeException {
        Optional<EmployeeEntity> employeeById = employeeRepository.findById(empId);
        if(employeeById.isPresent()) {
            //employeeById.get().setSalary(employee.getSalary());
            EmployeeEntity updatedEmployee = employeeRepository.save(employeeById.get());

            return Convertor.entityToModel(updatedEmployee);
        } else {
            throw new EmployeeException("Employee with ID " +empId+ "not found");
        }
    }

    @Override
    public Employee getEmployeeById(Long id)throws EmployeeException {
        Optional<EmployeeEntity> employeeById = employeeRepository.findById(id);
        if(!employeeById.isPresent())
            throw new EmployeeException("Employee with ID " + id + "not found");

        EmployeeEntity employeeEntity = employeeById.get();
        return Convertor.entityToModel(employeeEntity);
    }

    @Override
    public List<Employee> getAllEmployee() throws EmployeeException{
        List<EmployeeEntity> entities = employeeRepository.findAll();
        if(entities.isEmpty()) {
            throw new EmployeeException("No record found in database");
        }
        return  Convertor.entityToModel(entities);
    }

    @Override
    public void deleteEmployeeById(Long id) throws EmployeeException {
          if(id != null)
            employeeRepository.deleteById(id);
          else
              throw new EmployeeException("Employee with ID " + id + " not found");
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String name) {

        List<EmployeeEntity> byEmplyeeEmpFirstName = employeeRepository.findByEmpFirstNameLike(name);
        if(byEmplyeeEmpFirstName.isEmpty())
            throw new EmployeeException("Employee first name can not be found");
        return Convertor.entityToModel(byEmplyeeEmpFirstName);
    }

    @Override
    public List<EmployeeEntity> getEmployeePagination(Integer pageNumber, Integer pageSize) {
        Sort sort =Sort.by(Sort.Direction.ASC,"salary");
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);

        //Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
//      Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<EmployeeEntity> entityPage = employeeRepository.findAll(pageable);
        List<EmployeeEntity> employees = entityPage.getContent();
        
        
        return employees;
    }
}
