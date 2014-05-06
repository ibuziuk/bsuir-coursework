package bsuir.coursework.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bsuir.coursework.model.Customer;
import bsuir.coursework.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer")
	public String listCustomers(Map<String, Object> map) {
		map.put("customer", new Customer());
		map.put("customerList", customerService.listCustomers());
		return "customer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer( @Valid @ModelAttribute("customer") Customer customer, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("customerList", customerService.listCustomers());
			return "customer";
		} 
		customerService.addCustomer(customer);
		return "redirect:/customer";
	}

	@RequestMapping("/deleteCustomer/{customerId}")
	public String deleteProject(@PathVariable("customerId") Integer customerId) {
		customerService.removeCustomer(customerId);
		return "redirect:/customer";
	}
}
