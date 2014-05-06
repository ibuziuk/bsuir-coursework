package bsuir.coursework.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bsuir.coursework.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void removeCustomer(Integer id) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
		if (customer != null) {
			sessionFactory.getCurrentSession().delete(customer);
		}
	}
}
