package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class cascadeExample {

	public static void main(String[] args) {
		SessionFactory sessionfac = new Configuration().configure("com/cascade/hibernate.cfg.xml").buildSessionFactory();
		Session s = sessionfac.openSession();
		
		Question q1 = new Question();
		q1.setQid(245);
		q1.setQue("What is swing framework............");
		
		Answer a1 = new Answer(12341,"1 answer",q1);
		Answer a2= new Answer(1231,"2 answer",q1);
		Answer a3 = new Answer(121,"3 answer",q1);
		
		List<Answer> list = new ArrayList();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAns1(list);
        
        Transaction tx = s.beginTransaction();
		
		s.save(q1);
		
        tx.commit();
        s.close();
		sessionfac.close();
	}

}
