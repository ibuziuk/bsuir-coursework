package bsuir.coursework.service;

import java.util.List;

import bsuir.coursework.model.Employee;

public interface EmployeeService {
	void addEmployee(Employee employee);

	List<Employee> listEmployees();

	void removeEmployee(Integer id);
	
	List<Employee> getUnassignedEmployees();
}
