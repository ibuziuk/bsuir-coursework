package bsuir.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import bsuir.coursework.model.Employee;
import bsuir.coursework.model.Role;
import bsuir.coursework.service.EmployeeService;
import bsuir.coursework.service.RoleService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/roles")
	public List<Role> getRoles() {
		return roleService.getRoles();
	}
	
	@RequestMapping("/unassigned")
	public List<Employee> getUnasigned() {
		return employeeService.getUnassignedEmployees();
	}
	
}
