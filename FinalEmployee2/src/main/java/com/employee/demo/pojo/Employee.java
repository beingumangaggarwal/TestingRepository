package com.employee.demo.pojo;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.employee.enums.Department;
import com.employee.enums.Transport;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	private String id;

	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "contact")
	private int contact;
	@Column(name = "department")
	@Enumerated(EnumType.STRING) 
	private Department department;
	@Column(name = "transport")
	@Enumerated(EnumType.STRING)
	private Transport transport;
	@Column(name = "doj")
	private LocalDate doj;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "salary")
	private long salary;
	
	
	public Employee() {
		super();
	}

	public Employee(String id, String name, int age, int contact,
			Department department, Transport transport, LocalDate doj,
			LocalDate dob, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.department = department;
		this.transport = transport;
		this.doj = doj;
		this.dob = dob;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

}
