package com.myt.repository;

import com.myt.entity.EmployeeEntity;
import com.myt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
   public List<EmployeeEntity> findByEmpFirstNameLike(String name);
}
