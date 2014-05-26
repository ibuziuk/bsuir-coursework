package bsuir.coursework.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import bsuir.coursework.dao.CustomerDAO;
import bsuir.coursework.service.CustomerService;

public class CustomerServiceTest {

	@Mock
	private CustomerDAO customerDAO;
	@Autowired
	private CustomerService customerService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void customerTest() {
		
	}

}
