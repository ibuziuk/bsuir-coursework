package bsuir.coursework.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import bsuir.coursework.model.Employee;
import bsuir.coursework.model.Project;
import bsuir.coursework.service.CustomerService;
import bsuir.coursework.service.EmployeeService;
import bsuir.coursework.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProjects(Map<String, Object> map) {
		map.put("project", new Project());
		map.put("customerList", customerService.listCustomers());
		map.put("projectList", projectService.listProjects());
		return "project";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Map<String, Object> map, HttpSession session) {
		if (result.hasErrors()) {
			map.put("projectList", projectService.listProjects());
			map.put("customerList", customerService.listCustomers());
			return "project";
		}
		projectService.addProject(project);
		return "redirect:/project";
	}
	
	@RequestMapping(value = "/edit/{projectId}", method = RequestMethod.POST)
	public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
			Map<String, Object> map, HttpSession session, SessionStatus status) {
		if (result.hasErrors()) {
			map.put("customerList", customerService.listCustomers());
			return "editProject";
		}
		projectService.updateProject(project);
		status.setComplete();
		return "redirect:/project";
	}
	
	@RequestMapping(value = "/edit/{projectId}", method = RequestMethod.GET)
	public String updateProject(@PathVariable("projectId") Integer projectId, Map<String, Object> map) {
		Project project = projectService.getProjectById(projectId);
		map.put("project", project);
		map.put("customerList", customerService.listCustomers());
		return "editProject";
	}
	
	
	@RequestMapping("/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId") Integer projectId) {
		projectService.removeProject(projectId);
		return "redirect:/project";
	}
		
	@RequestMapping("/getTeam/{projectId}")
	public String getTeam(@PathVariable("projectId") Integer projectId, Map<String, Object> map) {
		Project project = projectService.getProjectById(projectId);
		List<Employee> emplyeesAssignedToProject = employeeService.getEmplyeesAssignedToProject(projectId);
		map.put("team", emplyeesAssignedToProject);
		map.put("project", project);
		return "team";
	}
}
