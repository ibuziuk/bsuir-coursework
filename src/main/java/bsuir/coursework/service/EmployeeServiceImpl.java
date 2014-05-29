package bsuir.coursework.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bsuir.coursework.dao.EmployeeDAO;
import bsuir.coursework.model.Employee;
import bsuir.coursework.model.Project;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		Project project = employee.getProject();
		if (project.getId() == null) {
			employee.setProject(null);
		}
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

	@Override
	@Transactional
	public List<Employee> getUnassignedEmployees() {
		return employeeDAO.getUnassignedEmployees();
	}

	@Override
	@Transactional
	public List<Employee> getEmplyeesAssignedToProject(Integer projectId) {
		return employeeDAO.getEmplyeesAssignedToProject(projectId);
	}

}
