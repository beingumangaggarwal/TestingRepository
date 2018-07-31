package com.employee.demo.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.pojo.Employee;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.enums.Department;
import com.employee.enums.Transport;
import com.google.common.collect.Lists;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Iterable<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployee(String id) {

		return employeeRepository.findById(id);
	}

	public void saveEmployee(Employee person) {

		employeeRepository.save(person);
	}

	public void deleteEmployee(String id) {

		employeeRepository.deleteById(id);
	}

	public void getEmployeeId() {
		employeeRepository.findAll();

	}

	public void saveAllEmployee(Iterable<Employee> person) {
		employeeRepository.saveAll(person);

	}

	public void updateAllEmployee(Iterable<Employee> person) {
		employeeRepository.saveAll(person);

	}

	public void deleteAllEmployee() {
		employeeRepository.deleteAll();
	}

	public List<Employee> getEmployeeAge(String check, Integer age) {

		Iterable<Employee> employee = employeeRepository.findAll();

		List<Employee> employeeList = Lists.newArrayList(employee);

		if ("Greater".equalsIgnoreCase(check)) {
			return employeeList.stream().filter(p -> p.getAge() > age)
					.collect(Collectors.<Employee> toList());
		} else {
			return employeeList.stream().filter(p -> p.getAge() < age)
					.collect(Collectors.<Employee> toList());
		}

	}

	public List<Employee> getEmployeeSalary(String check, Integer salary) {

		Iterable<Employee> employee = employeeRepository.findAll();

		List<Employee> employeeList = Lists.newArrayList(employee);

		if ("Greater".equalsIgnoreCase(check)) {
			return employeeList.stream().filter(p -> p.getSalary() > salary)
					.collect(Collectors.<Employee> toList());
		} else {
			return employeeList.stream().filter(p -> p.getSalary() < salary)
					.collect(Collectors.<Employee> toList());
		}

	}

	public List<Employee> getDepartment(Department department) {

		Iterable<Employee> employee = employeeRepository.findAll();

		List<Employee> employeeList = Lists.newArrayList(employee);

		return employeeList.stream()
				.filter(p -> p.getDepartment() == department)
				.collect(Collectors.<Employee> toList());

	}

	public List<Employee> getEmployeeTransport(Transport transport) {

		Iterable<Employee> employee = employeeRepository.findAll();

		List<Employee> employeeList = Lists.newArrayList(employee);

		return employeeList.stream().filter(p -> p.getTransport() == transport)
				.collect(Collectors.<Employee> toList());

	}

	public List<Employee> getEmployeeBirthday(int bday) {

		Iterable<Employee> employee = employeeRepository.findAll();

		List<Employee> employeeList = Lists.newArrayList(employee);

		return employeeList.stream()
				.filter(p -> p.getDob().getMonthValue() == bday)
				.collect(Collectors.<Employee> toList());

	}

}
