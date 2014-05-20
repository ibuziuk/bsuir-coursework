package bsuir.coursework.dao;

import java.util.List;

import bsuir.coursework.model.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer);
	List<Customer> listCustomers();
	void removeCustomer(Integer id);
	Customer getCustomerById(Integer id);
}
