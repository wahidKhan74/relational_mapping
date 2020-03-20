package com.simplilearn.hibernate.relationship.mapping.many2many.bi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernate.relationship.mapping.entity2.Employee;
import com.simplilearn.hibernate.relationship.mapping.entity2.Project;


public class CreateProjectThenAddEmployee {

	public static void main(String[] args) {
		
		//1. create session factory 
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Project.class)
								.buildSessionFactory();
		
		//2.create a session (open a session)
		Session session = factory.getCurrentSession();
		
		// 3. perform operations
		try {
			
			
			//start transaction
			session.beginTransaction();
			
			Project project = new Project("G-221", "Global Health Online Doctor");
			
			session.save(project);
			
			System.out.println("Project -> "+ project);
			
			//create 3 employee
			Employee employee1 = new Employee("Sam", "Mill", 3000, "Dev");
			
			Employee employee2 = new Employee("Sam", "Mill", 3000, "Dev");
			
			Employee employee3 = new Employee("Sam", "Mill", 3000, "Dev");
			
			project.add(employee1);
			project.add(employee2);
			project.add(employee3);
			
//			project1.setEmployee(employee);
//			project2.setEmployee(employee);
//			List<Project> list  = new ArrayList<Project>();
//			list.add(project1);
//			list.add(project1);			
//			employee.setProjects(list);
			
			
			session.save(employee1);
			
			session.save(employee2);
			
			session.save(employee3);
			
			System.out.println("Saved Employees ->" + project.getEmployees());
			
			session.getTransaction().commit();
			
			System.out.print("Done!");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session
			session.close();
			//close session factory
			factory.close();
		}
		
		

	}

}
