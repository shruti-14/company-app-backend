package com.example.Company.employee.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.Company.department.model.Department;
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

//	@Id
//	private long sso;
	
	@Id
	@Column(name="sso")
	private long sso;
	
	@Column(name="EmployeeName")
	private String employeeName;
	
	@Column(name="Age")
	private int age;
	
	@Column(name="Salary")
	private double salary;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="isPermanent")
	private Boolean isPermanent;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Email")
	private String email;
	
	
	
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="dep_Id",referencedColumnName="dep_Id")
	private Department department;
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getSso() {
		return sso;
	}

	public void setSso(long sso) {
		this.sso = sso;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsPermanent() {
		return isPermanent;
	}

	public void setIsPermanent(Boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee() {
	}
	
	public Employee(long sso, String employeeName, int age, double salary, String gender, Boolean isPermanent, String address, String email) {
           this.sso=sso;
           this.employeeName=employeeName;
           this.age=age;
           this.salary=salary;
           this.gender=gender;
           this.isPermanent=isPermanent;
           this.address=address;
           this.email=email;
		   
	}	
	public Employee(long sso, String employeeName, int age, double salary, String gender, Boolean isPermanent, String address, String email,Department department) {
        this.sso=sso;
        this.employeeName=employeeName;
        this.age=age;
        this.salary=salary;
        this.gender=gender;
        this.isPermanent=isPermanent;
        this.address=address;
        this.email=email;
		this.department=department;
	}	
	@Override
	public String toString() {
		return String.format("Employee[sso=%ld, employeeName='%s', salary=%f, isPermanent='%b']", sso, employeeName, salary,isPermanent);
	}
}
