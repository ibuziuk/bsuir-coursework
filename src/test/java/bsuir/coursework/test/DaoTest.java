package bsuir.coursework.test;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import bsuir.coursework.dao.EmployeeDAO;
import bsuir.coursework.dao.ProjectDAO;
import bsuir.coursework.model.Employee;
import bsuir.coursework.model.Project;


@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-servlet-context.xml"})
@TransactionConfiguration(defaultRollback = true)
public class DaoTest {
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public DaoTest() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

    @Autowired
    private ProjectDAO projectDao;
    
    @Autowired
    private EmployeeDAO employeeDao;

    @Test
    @Transactional
    public void testProjectBudget() throws Exception {
    	List<Project> projects = projectDao.listProjects();
    	if (!projects.isEmpty()) {
            Project first = projects.get(0);
            first.setName("Test");
            Integer budget = first.getBudget();
            Assert.assertTrue(budget > 1000);
    	}	
    }
    
    
    @Test
    @Transactional
    public void testEmployeeEmail() throws Exception {
    	List<Employee> employees = employeeDao.listEmployees();
    	if (!employees.isEmpty()) {
            Employee first = employees.get(0);
            first.setName("Test");
            String email = first.getEmail();
            Assert.assertNotNull(email);  
            Assert.assertTrue(validate(email));
    	}	
    }
        
	private boolean validate(final String hex) {
		matcher = pattern.matcher(hex);
		return matcher.matches();
	}
    
}