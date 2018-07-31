package com.employee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.pojo.Employee;
import com.employee.demo.service.EmployeeService;
import com.employee.enums.Department;
import com.employee.enums.Transport;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/getAllEmployee")
	public Iterable<Employee> getAllEmployees() {

		return employeeService.getAllEmployee();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveEmployee")
	public String postEmployee(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);

		return "Employee Save Successfully";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveAllEmployee")
	public String postEmployeeList(@RequestBody Iterable<Employee> employee) {

		employeeService.saveAllEmployee(employee);

		return "Employees Save Successfully";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateAllEmployee")
	public String updateEmployeeList(@RequestBody Iterable<Employee> employee) {

		employeeService.updateAllEmployee(employee);

		return "Employees Updated Successfully";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteEmployee/{id}")
	public String deleteEmployees(@PathVariable String id) {
		employeeService.deleteEmployee(id);

		return "Employee Deleted Successfully";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllEmployees")
	public String deleteAllEmployees() {
		employeeService.deleteAllEmployee();

		return "Employees Deleted Successfully";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateEmployee/{id}")
	public String updateEmployees(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);

		return "Employee Updated Successfully";
	}

	@RequestMapping(value = "/getEmployeeAge")
	@ResponseBody
	public List<Employee> getEmployeeAge(
			@RequestParam(value = "check", required = false) String check,
			@RequestParam(value = "age", required = false, defaultValue = "default") Integer age) {

		return employeeService.getEmployeeAge(check, age);

	}

	@RequestMapping(value = "/getEmployeeSalary")
	@ResponseBody
	public List<Employee> getEmployeeSalary(
			@RequestParam(value = "check", required = false) String check,
			@RequestParam(value = "salary", required = false, defaultValue = "default") Integer salary) {

		return employeeService.getEmployeeSalary(check, salary);

	}

	@RequestMapping(value = "/getEmployeeDepartment")
	@ResponseBody
	public List<Employee> getDepartment(
			@RequestParam(value = "department", required = false, defaultValue = "default") Department department) {

		return employeeService.getDepartment(department);

	}

	@RequestMapping(value = "/getEmployeeTransport")
	@ResponseBody
	public List<Employee> getEmployeeTransport(
			@RequestParam(value = "transport", required = false, defaultValue = "default") Transport transport) {

		return employeeService.getEmployeeTransport(transport);
	}

	@RequestMapping(value = "/getEmployeeBirthday")
	@ResponseBody
	public List<Employee> getEmployeeBirthday(
			@RequestParam(value = "birthday", required = false, defaultValue = "default") int bday) {

		return employeeService.getEmployeeBirthday(bday);

	}

}
