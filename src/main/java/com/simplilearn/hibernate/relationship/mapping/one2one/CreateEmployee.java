package com.simplilearn.hibernate.relationship.mapping.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernate.relationship.mapping.entity.Employee;
import com.simplilearn.hibernate.relationship.mapping.entity.Payroll;


public class CreateEmployee {

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
			
			Employee employee = new Employee("Mark", "Smith", 3000, "Dev");
			Payroll payroll = new Payroll("1000$", "3000$", "$2800$", "200$");
			
			employee.setPayroll(payroll);
			
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
