package com.myt.controller;

import com.myt.entity.EmployeeEntity;
import com.myt.exception.EmployeeException;
import com.myt.model.Employee;
import com.myt.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

//@RestController( value = "/api/v1/employee")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    public static final Logger logger = LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;


    // @PostMapping(path = "/addemployee")
    @PostMapping("/addemployee")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee) {
        logger.info("inside controller addEmployee method");
        logger.debug("Employee info: " + employee.toString());

      try {
           Employee employeeResponse = employeeService.addEmployee(employee);
           logger.info("EmployeeResponse info "+ employeeResponse);
           return  ResponseEntity.ok(employeeResponse);
       }

      catch (EmployeeException e) {
           logger.error("Error Message : "+ e.getMessage());
           return new ResponseEntity(getErrorResponse("404", e.getMessage()), HttpStatus.NOT_FOUND);

       }

       catch(Exception e) {
           logger.error("Error Message : Exception " + e.getMessage());
           return new ResponseEntity(getErrorResponse("500", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

       }

    }

    @PutMapping("/updateEmployee/{empId}")
    public Employee updateEmployeeById(@PathVariable("empId") Long id, @RequestBody Employee employee) {
        logger.info("inside controller updateEmployeeById method");
        return employeeService.updateEmployeeById(employee, id);
    }

    @GetMapping(value = "/getemployeebyid/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        logger.info("inside controller getEmployeeById");
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/getallemployee")
    public List<Employee> getAllEmployee() {
        logger.info("inside controller getAllEmployee method");
        return employeeService.getAllEmployee();
    }

    @DeleteMapping(value = "/deleteEmployeeById/{id}")
    void deleteEmployeeById(@PathVariable("id") Long id) {
        logger.info("inside controller deleteEmployeeById method");
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping(value = "/getemployeebyfirstname")
    public List<Employee> findEmployeeByFirstName(@RequestParam("firstName") String firstName) {
        return employeeService.getEmployeeByFirstName(firstName);


    }

    public HashMap<String, String> getErrorResponse(String errorCode, String error) {
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("code", errorCode);
        errorMap.put("msg", error);
        return errorMap;
    }
    @GetMapping("/pagingAndSortingEmployee/{pageNumber}/{pageSize}")
    public List<EmployeeEntity> employeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return employeeService.getEmployeePagination(pageNumber,pageSize);
    }
}
