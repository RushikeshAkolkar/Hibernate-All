package com.manytoone;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.onetoone.*;
public class MapDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("com/manytoone/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//        Question q1 = new Question();
//        q1.setQid(1);
//        q1.setQue("What is Java?");
//        
//        Answer a1 = new Answer();
//        a1.setAid(1);
//        a1.setAns("Ok, it is programming language");
//        a1.setQue1(q1);
//        
//        
//        Answer a2 = new Answer();
//        a2.setAid(2);
//        a2.setAns("Object Oriented Language");
//        a2.setQue1(q1);
//        
//        List<Answer> list = new ArrayList<Answer>();
//        list.add(a1);
//        list.add(a2);
//        //session
//        
//        q1.setAns1(list);
//        
//        
        Session s = factory.openSession();
        
        Transaction tx = s.beginTransaction();
        
        //save
//        s.save(q1);
//        s.save(a1);
//        s.save(a2);
       
        
        Question q = (Question)s.get(Question.class, 1);
        System.out.println(q.getQue());
        
        for(Answer a: q.getAns1()) {
        	System.out.println(a.getAns());
        }
//        Lazy loading        
//        System.out.println(q.getAns1().size());
        
        System.out.println();
        tx.commit();
        
        
     
        s.close();
        factory.close();

	}
}