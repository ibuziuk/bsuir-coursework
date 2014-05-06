package bsuir.coursework.service;

import java.util.List;

import bsuir.coursework.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	List<Customer> listCustomers();
	void removeCustomer(Integer id);
}
