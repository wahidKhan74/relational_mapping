package com.simplilearn.hibernate.relationship.mapping.one2one;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernate.relationship.mapping.entity.Employee;
import com.simplilearn.hibernate.relationship.mapping.entity.Payroll;


public class ReadAllEmployee {

	public static void main(String[] args) {
		
		//1. create session factory 
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Payroll.class)
								.buildSessionFactory();
		
		//2.create a session (open a session)
		Session session = factory.getCurrentSession();
		
		// 3. perform operations
		try {
			//start transaction
			session.beginTransaction();
			
			List <Employee>listOfEmp = session.createQuery("from Employee as e").getResultList();
			display(listOfEmp);					
			
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
	
	// display
	 	private static void display(List <Employee> listOfEmp) {		
	 		for(Employee emp : listOfEmp) {			
	 			System.out.println("Employee->" + emp);	
	 			System.out.println("Payroll->" + emp.getPayroll());
	 		}
	 	}

}
