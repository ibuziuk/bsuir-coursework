package bsuir.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bsuir.coursework.dao.CustomerDAO;
import bsuir.coursework.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return customerDAO.listCustomers();
	}

	@Override
	@Transactional
	public void removeCustomer(Integer id) {
		customerDAO.removeCustomer(id);
	}

}
