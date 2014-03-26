package bsuir.coursework.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bsuir.coursework.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addProject(Project project) {
		sessionFactory.getCurrentSession().save(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> listProjects() {
	      return sessionFactory.getCurrentSession().createQuery("from Project").list();
	}

	@Override
	public void removeProject(Integer id) {
		 Project project = (Project) sessionFactory.getCurrentSession().load(Project.class, id);
		 if (project != null) {
			 sessionFactory.getCurrentSession().delete(project);
		 }
	}

}
