package bsuir.coursework.dao;

import java.util.List;

import bsuir.coursework.model.Project;

public interface ProjectDAO {
	void addProject(Project project);

	List<Project> listProjects();
	
	void updateProject(Project project);

	void removeProject(Integer id);
	
	Project getProjectById(Integer id);
}
