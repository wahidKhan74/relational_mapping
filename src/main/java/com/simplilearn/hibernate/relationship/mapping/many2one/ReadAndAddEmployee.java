package com.simplilearn.hibernate.relationship.mapping.many2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernate.relationship.mapping.entity.Employee;
import com.simplilearn.hibernate.relationship.mapping.entity.Payroll;
import com.simplilearn.hibernate.relationship.mapping.entity.Project;


public class ReadAndAddEmployee {

	public static void main(String[] args) {
		
		//1. create session factory 
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Payroll.class)
								.addAnnotatedClass(Project.class)
								.buildSessionFactory();
		
		//2.create a session (open a session)
		Session session = factory.getCurrentSession();
		
		// 3. perform operations
		try {
			//start transaction
			session.beginTransaction();
			
			int theId = 6;			
			Employee employee = session.get(Employee.class, theId);
			
			if(employee !=null) {
				System.out.println("Employee -> "+employee);
				
				System.out.println("Projects -> "+employee.getProjects());
				
				Project project3 = new Project("A123", "Online EMS System");
				
				Project project4 = new Project("A124", "AI automation");
				
				employee.add(project4);
				employee.add(project3);
				
				session.save(project3);
				session.save(project4);
				
				session.getTransaction().commit();
				
				System.out.println("Deleted");
				
			}else {
				
				
				System.out.println("Employee Not Found with Id -> "+theId);
			}
			
			
			
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
