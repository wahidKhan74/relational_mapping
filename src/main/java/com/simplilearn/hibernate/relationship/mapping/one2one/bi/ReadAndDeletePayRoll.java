package com.simplilearn.hibernate.relationship.mapping.one2one.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernate.relationship.mapping.entity.Employee;
import com.simplilearn.hibernate.relationship.mapping.entity.Payroll;


public class ReadAndDeletePayRoll {

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
			
			int theId = 3;			
			Payroll payroll = session.get(Payroll.class, theId);
			
			if(payroll !=null) {
				System.out.println("payroll -> "+payroll);
				
				System.out.println("PayRoll Employee -> "+payroll.getEmployee());
				
				
				//Not e Will also delete associated "payroll with employee"
				// because of CasecadeType.ALL
				session.delete(payroll);
				
				session.getTransaction().commit();
				
				System.out.println("Deleted");
				
			}else {
				
				
				System.out.println("payroll Not Found with Id -> "+theId);
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
