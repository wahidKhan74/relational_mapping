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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ems_project_detail2")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_no")
	private String projectNo;
	
	@ManyToMany(cascade= { CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="employee_project_rel",
	joinColumns=@JoinColumn(name="project_id"),
	inverseJoinColumns= @JoinColumn(name="emp_id"))
	private List<Employee> employees;
	
	//constructor
	public Project() {}

	public Project(String projectName, String projectNo) {
		super();
		this.projectName = projectName;
		this.projectNo = projectNo;
	}
	
	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	
	
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	//override toString()
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectNo=" + projectNo + "]";
	}
	
	
	//add helper method for bidirectional rel.
		public void add(Employee emp) {
			if(employees == null) {
				employees = new ArrayList<Employee>();
			}
			employees.add(emp);
		}
	 
	
	

}
