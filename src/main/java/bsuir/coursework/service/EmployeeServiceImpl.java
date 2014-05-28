package bsuir.coursework.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bsuir.coursework.dao.EmployeeDAO;
import bsuir.coursework.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	@Override
	@Transactional
	public void removeEmployee(Integer id) {
		employeeDAO.removeEmployee(id);
	}

}
