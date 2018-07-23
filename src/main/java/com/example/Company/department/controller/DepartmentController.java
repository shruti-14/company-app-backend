package com.example.Company.department.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company.department.model.Department;
import com.example.Company.department.repo.DepartmentRepository;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@RequestMapping(value="/department",method=RequestMethod.GET, produces="application/json")
	public List<Department> getAllDepartment(){
		List<Department> list= new ArrayList<>();
		Iterable<Department> department= departmentRepository.findAll();
		
		department.forEach(list::add);
		return list;
	}
	
	@RequestMapping(value="/postdepartment",method=RequestMethod.POST)
	public String postDepartment(@RequestBody Department[] department) {
		Arrays.stream(department)
		.forEach(e-> departmentRepository.save(new Department(e.getId(),e.getDepartmentName(),e.getDescription())));
		return "Success";
	}

}
