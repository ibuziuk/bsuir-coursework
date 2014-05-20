package bsuir.coursework.service;

import java.util.List;

import bsuir.coursework.model.Project;

public interface ProjectService {
	void addProject(Project project, Integer customerId);
	List<Project> listProjects();
	void removeProject(Integer id);
}
