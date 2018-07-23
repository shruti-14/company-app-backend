package com.example.Company.employee.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Company.employee.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
