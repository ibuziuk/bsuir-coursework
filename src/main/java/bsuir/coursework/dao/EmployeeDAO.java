package bsuir.coursework.dao;

import java.util.List;

import bsuir.coursework.model.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee employee);
	List<Employee> listEmployees();
	void removeEmployee(Integer id);
}
