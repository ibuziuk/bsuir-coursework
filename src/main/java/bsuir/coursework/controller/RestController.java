package bsuir.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	
	/*
	 * Parsing custom json from client
	 */
	@RequestMapping(value = "/customJSON", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addRole(HttpEntity<String> httpEntity) {
		String jsonString = httpEntity.getBody();
		JsonObject json= new JsonParser().parse(jsonString).getAsJsonObject();
		System.out.println(json.get("name"));
	}
	
	
	@RequestMapping("/roles")
	public List<Role> getRoles() {
		return roleService.getRoles();
	}
	
	@RequestMapping("/unassigned")
	public List<Employee> getUnasigned() {
		return employeeService.getUnassignedEmployees();
	}
	
}
