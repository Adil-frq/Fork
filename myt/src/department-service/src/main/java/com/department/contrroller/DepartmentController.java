package com.department.contrroller;

import com.department.model.Department;
import com.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/savedepartment")
    public Department addDepartment(@RequestBody Department department) {
        logger.info("DepartmentController->saveDepartment");
       return departmentService.addDepartment(department);
    }

    @GetMapping("/getalldepartment")
    public List<Department> getAllDepartment() {
        logger.info("DepartmentController->getAllDepartment");

        return departmentService.getAllDepartment();
    }

    @GetMapping("/getDepartmentbyid/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) {
        logger.info("DepartmentController->getDepartmentById");
        return departmentService.getDepartmentById(id);
    }
    @GetMapping("/getDepartmentByName")
    public List<Department> getDepartmentByName(@RequestParam("deptName") String deptName) {
        logger.info("DepartmentController->getDepartmentById : "+ deptName);
        return departmentService.getDepartmentByName(deptName);
    }

    @DeleteMapping("/deletedepartmentbyid/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id) {
        logger.info("DepartmentController -> deleteDepartmentById : "+ id);
        departmentService.deleteDepartmentById(id);
    }
    @PutMapping("/updateemployeebyid/{id}")
    public Department updateEmployeeById(@RequestBody Department department, @PathVariable("id") Long id) {
        logger.info("DepartmentController -> updateEmployeeById "+id);
        return departmentService.updateEmployeeById(department, id);
    }


    @GetMapping("/getdepartentpagination/{pageNumber}/{pageSize}")
    public List<Department> getDepartentPagination(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {

        return departmentService.getDepartentPagination(pageNumber,pageSize);
    }
}
