package com.example.Company.department.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.Company.employee.model.Employee;
@Entity
@Table(name="Department")
public class Department implements Serializable {

	@Id
	@NotNull
	@Column(name="dep_Id")
	private long id;
	
	@Column(name="DepartmentName")
	private String departmentName;
	
	@Column(name="Description")
	private String description;
	
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="department",targetEntity=Employee.class)
	private List<Employee> employee;	
	
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public  Department(long id, String departmentName, String description) {
		this.id=id;
		this.departmentName=departmentName;
		this.description=description;
	}
	public  Department(long id, String departmentName, String description,List<Employee> employee) {
		this.id=id;
		this.departmentName=departmentName;
		this.description=description;
		this.employee= employee;
	}
	
	public  Department() {		
	}
	
	@Override
	public String toString() {
		
		return String.format("Department[id=%ld, departmentName='%s', description='%s']", id,departmentName,description);
	}
	
	
	
}
