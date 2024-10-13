package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		//1.Transiant
		//2.Persistance
		//3.Detached
		//4.Remove
		System.out.println("EXAMPLE OF LIFECYCLE :");
		
		SessionFactory factory = new Configuration().configure("com/state/hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Student Object:
		
		Student s = new Student();
		s.setId(13);
		s.setName("Raghu");
		s.setCity("Pune");
		s.setCerti(new Certificate("java Hibernate ","2 Months"));
		//student in transiant state

		
		Session se = factory.openSession();
		Transaction tx=se.beginTransaction();
		se.save(s);
		//Student in persistant state means avaliable in session,database also change in database
		s.setName("Swati Bai");
		
		tx.commit();
		s.setName("Sachin");
		se.close();
		//at this poistion not store in database if we are store in database only store in session
		////Now Student in detaches: state
		s.setName("Rohit");
		factory.close();
	}
}
