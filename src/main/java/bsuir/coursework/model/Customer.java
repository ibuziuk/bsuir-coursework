package bsuir.coursework.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")  
	private Integer customerId;
	
	@NotEmpty
	private String name;

    @OneToMany(mappedBy="customer")
    private Set<Project> projects;

	public Integer getId() {
		return customerId;
	}

	public void setId(Integer id) {
		this.customerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
