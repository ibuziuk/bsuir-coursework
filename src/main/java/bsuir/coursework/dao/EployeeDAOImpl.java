package bsuir.coursework.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bsuir.coursework.model.Employee;

@Repository
public class EployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void removeEmployee(Integer id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
		if (employee != null) {
			sessionFactory.getCurrentSession().delete(employee);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getUnassignedEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee where project is null").list();
	}

}
