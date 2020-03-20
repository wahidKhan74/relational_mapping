package com.simplilearn.hibernate.relationship.mapping.many2many.bi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernate.relationship.mapping.entity2.Employee;
import com.simplilearn.hibernate.relationship.mapping.entity2.Project;


public class CreateEmployee {

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
			
			Employee employee = new Employee("Sam", "Mill", 3000, "Dev");
			
			
			Project project1 = new Project("M221", "Online PT");
			
			Project project2 = new Project("M221", "System AI");
			
			employee.add(project1);
			employee.add(project2);
			
//			project1.setEmployee(employee);
//			project2.setEmployee(employee);
//			List<Project> list  = new ArrayList<Project>();
//			list.add(project1);
//			list.add(project1);			
//			employee.setProjects(list);
			
			session.save(project1);
			session.save(project2);
			
			session.save(employee);
			
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
