package com.department.service.impl;

import com.department.constant.ExceptionConstant;
import com.department.entity.DepartmentEntity;
import com.department.exception.DepartmentException;
import com.department.model.Department;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;
import com.department.util.Convertor;
import com.department.validation.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department) throws DepartmentException {
        if(department != null)
            ValidateData.validate(department);

        DepartmentEntity departmentEntity = Convertor.modelToEntity(department);
        DepartmentEntity saveDepartment = departmentRepository.save(departmentEntity);
        return Convertor.entityToModel(saveDepartment);
    }

    public List<Department> getAllDepartment() throws DepartmentException{
        List<DepartmentEntity> DepartmentList = departmentRepository.findAll();
        return Convertor.entityToModel(DepartmentList);
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentException {
        Optional<DepartmentEntity> departmentByid = departmentRepository.findById(id);
        Department department = null;
        if(departmentByid.isPresent()) {
             return Convertor.entityToModel(departmentByid.get());
        }
        throw new DepartmentException(ExceptionConstant.RECORD_NOT_FOUND_FOR_ID + id);
    }

    @Override
    public List<Department> getDepartmentByName(String deptName) throws DepartmentException {
        List<DepartmentEntity> bydepartmentName = departmentRepository.findBydepartmentName(deptName);
        return Convertor.entityToModel(bydepartmentName);
    }

    @Override
    public void deleteDepartmentById(Long id) throws DepartmentException {
        Optional<DepartmentEntity> DepartmentById = departmentRepository.findById(id);
        DepartmentById.orElseThrow(()-> new DepartmentException(ExceptionConstant.RECORD_NOT_FOUND_FOR_ID + id));
        departmentRepository.deleteById(id);
    }

    public Department updateEmployeeById(Department department , Long id) throws DepartmentException {
        Optional<DepartmentEntity> departmentById = departmentRepository.findById(id);
        departmentById.orElseThrow(()->new DepartmentException(ExceptionConstant.RECORD_NOT_FOUND_FOR_ID + id));
        department.setDepartmentId(id);
        DepartmentEntity departmentEntity = Convertor.modelToEntity(department);

        return Convertor.entityToModel(departmentRepository.save(departmentEntity));
    }

    @Override
    public List<Department> getDepartentPagination(int pageNumber, int pageSize) throws DepartmentException {
        Sort sort = Sort.by(Sort.Direction.ASC, "departmentName");
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<DepartmentEntity> pageOfDepartment = departmentRepository.findAll(pageable);
        List<DepartmentEntity> content = pageOfDepartment.getContent();
        return Convertor.entityToModel(content);
    }
}
