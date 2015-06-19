package bsuir.coursework.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bsuir.coursework.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username).list();
		return (users.size() > 0) ? users.get(0) : null;
	}

}
