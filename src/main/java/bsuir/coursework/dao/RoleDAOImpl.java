package bsuir.coursework.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bsuir.coursework.model.Customer;
import bsuir.coursework.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles() {
		 return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void removeRole(Integer id) {
		 Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);
		 if (role != null) {
			 sessionFactory.getCurrentSession().delete(role);
		 }
	}

	@Override
	public Role getRoleById(Integer id) {
		return (Role) sessionFactory.getCurrentSession().get(Customer.class, id);
	}

}
