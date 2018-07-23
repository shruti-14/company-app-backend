package com.example.Company.department.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.Company.department.model.Department;

public interface DepartmentRepository extends CrudRepository <Department, Long> {

}
    