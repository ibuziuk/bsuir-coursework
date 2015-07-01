package bsuir.coursework.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import bsuir.coursework.validator.CustomerCheck;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")  
	private Integer projectId;
	
	@NotEmpty
	private String name;
	
	@NotNull @Min(1000)
	private Integer budget;
	
	@NotNull
	@ManyToOne
	@CustomerCheck
	@JoinColumn(name="customer_id")	
	private Customer customer;
	
    @OneToMany(mappedBy="project", cascade=CascadeType.REMOVE)
    private Set<Employee> employees;

	public Integer getId() {
		return projectId;
	}

	public void setId(Integer id) {
		this.projectId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
