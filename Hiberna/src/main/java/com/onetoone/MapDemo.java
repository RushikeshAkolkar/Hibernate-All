package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.onetoone.*;
public class MapDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("com/onetoone/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question q1 = new Question();
        q1.setQid(1);
        q1.setQue("What is Java");
        
        Answer a1 = new Answer();
        a1.setAid(235);
        a1.setAns("Ok, it is programming language");
        a1.setQue1(q1);
        q1.setAns(a1);
        
        Question q2 = new Question();
        q2.setQid(211);
        q2.setQue("What is Collection framework");
        
        Answer a2 = new Answer();
        a2.setAid(233);
        a2.setAns("Ok, it is an api to work with java");
        a2.setQue1(q2);
        q2.setAns(a2);
        
        //session
        
        Session s = factory.openSession();
        
        Transaction tx = s.beginTransaction();
        
        //save
        s.save(a1);
        s.save(a2);
        s.save(q1);
        s.save(q2);
        
        tx.commit();
        
        
        //fatching
        Question ques = (Question)s.get(Question.class, 1);
        System.out.println(ques.getQue());
        System.out.println(ques.getAns().getAns());
        
        s.close();
        factory.close();

	}
}
