package bsuir.coursework.dao;

import java.util.List;

import bsuir.coursework.model.Project;

public interface ProjectDAO {
	void addProject(Project project);
	List<Project> listProjects();
	void removeProject(Integer id);
}
