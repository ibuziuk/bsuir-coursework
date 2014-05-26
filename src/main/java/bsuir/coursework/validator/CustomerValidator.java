package bsuir.coursework.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import bsuir.coursework.model.Customer;

public class CustomerValidator implements ConstraintValidator<CustomerCheck, Customer> {

	@Override
	public void initialize(CustomerCheck arg) {
	}


	@Override
	public boolean isValid(Customer customer, ConstraintValidatorContext ctx) {
		if (customer.getId() == null) {
			return false;
		}
		return true;
	}

}
