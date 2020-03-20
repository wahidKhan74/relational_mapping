package com.simplilearn.hibernate.relationship.mapping.entity2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ems_employee_detail2")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="dept")
	private String dept;
	
		
	@ManyToMany(cascade= { CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="employee_project_rel",
	joinColumns=@JoinColumn(name="emp_id"),
	inverseJoinColumns= @JoinColumn(name="project_id"))
	private List<Project> projects;
	
	// add empty constructor
	Employee(){};
	
	//add constructor with all fields
	public Employee(String firstName, String lastName, int salary, String dept) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	// toString()
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", dept=" + dept + "]";
	};
	
	//add helper method for bidirectional rel.
	public void add(Project pro) {
		if(projects ==null) {
			projects = new ArrayList<Project>();
		}
		projects.add(pro);
	}
}
