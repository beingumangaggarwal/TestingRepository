package com.employee.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.demo.pojo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
