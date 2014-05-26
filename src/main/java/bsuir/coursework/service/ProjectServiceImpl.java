package bsuir.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bsuir.coursework.dao.CustomerDAO;
import bsuir.coursework.dao.ProjectDAO;
import bsuir.coursework.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public void addProject(Project project) {
		projectDAO.addProject(project);
	}

	@Override
	@Transactional
	public List<Project> listProjects() {
		return projectDAO.listProjects();
	}

	@Override
	@Transactional
	public void removeProject(Integer id) {
		projectDAO.removeProject(id);
	}

}
