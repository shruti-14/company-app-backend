package com.example.Company.employee.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company.employee.model.Employee;
import com.example.Company.employee.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping(value="/employee" ,method =RequestMethod.GET,produces = "application/json")
	public List<Employee> getAllEmployees(){
		List<Employee> list= new ArrayList<>();
		Iterable<Employee> employees = repository.findAll();
		for (Employee employee : employees) {
			list.add(employee);
		}
		//employees.forEach(list::add);//TODO
		return list;
	}
	
	@RequestMapping(value="/postemployee", method = RequestMethod.POST)
	public String postEmployees(@RequestBody Employee[] employee) {
		Arrays.stream(employee)
		.forEach(e->repository.save(e));
		return "Success";
	}
	
	@RequestMapping(value="/employee/{sso}",method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable long sso) {
		repository.deleteById(sso);
	}
	
	@RequestMapping(value="/employee/all",method=RequestMethod.DELETE)
	public void deleteAllemployees() {
		repository.deleteAll();
	}
	
}
