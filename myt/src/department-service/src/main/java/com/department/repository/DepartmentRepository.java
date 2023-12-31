package com.department.repository;

import com.department.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    public List<DepartmentEntity> findBydepartmentName(String dName);
}
