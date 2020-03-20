package com.simplilearn.hibernate.relationship.mapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ems_project_detail")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_no")
	private String projectNo;
	
	@ManyToOne(cascade= { CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="emp_id")
	private Employee employee;
	
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

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	//override toString()
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectNo=" + projectNo + "]";
	}
	
	
	
	 
	
	

}
