package bsuir.coursework.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bsuir.coursework.model.Employee;
import bsuir.coursework.service.EmployeeService;
import bsuir.coursework.service.ProjectService;
import bsuir.coursework.service.RoleService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/unassigned", method = RequestMethod.GET)
	public String listUnassignedEmployees(Map<String, Object> map) {
		map.put("unassigedEmployees", employeeService.getUnassignedEmployees());
		return "unassignedEmployee";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listRoles(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("projectList", projectService.listProjects());
		map.put("roleList", roleService.getRoles());
		map.put("employeeList", employeeService.listEmployees());
		return "employee";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCustomer( @Valid @ModelAttribute("employee") Employee employee, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("roleList", roleService.getRoles());
			map.put("projectList", projectService.listProjects());
			map.put("employeeList", employeeService.listEmployees());
			return "employee";
		} 
		employeeService.addEmployee(employee);
		return "redirect:/employee";
	}

	@RequestMapping("/remove/{employeeId}")
	public String deleteProject(@PathVariable("employeeId") Integer employeeId) {
		employeeService.removeEmployee(employeeId);
		return "redirect:/employee";
	}
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
}
