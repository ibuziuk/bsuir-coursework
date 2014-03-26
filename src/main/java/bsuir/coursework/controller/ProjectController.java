package bsuir.coursework.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bsuir.coursework.model.Project;
import bsuir.coursework.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/")
	public String listProjects(Map<String, Object> map) {
		map.put("project", new Project());
		map.put("projectList", projectService.listProjects());
		return "project";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("project") Project project, BindingResult result) {
		projectService.addProject(project);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId") Integer projectId) {
		projectService.removeProject(projectId);
		return "redirect:/";
	}
}
