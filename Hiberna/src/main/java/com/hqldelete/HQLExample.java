package com.hqldelete;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class HQLExample {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("com/hqldelete/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        //HQL
        //SYNTAX
        String query="from Student where city=:x";    //also set city='pune' or from student as s wheres.city=:x
        
        Session session = factory.openSession();

        Query q = session.createQuery(query);
        
        q.setParameter("x","Pune");			// By setting forward reference to x
        
        //single - (unique)
        //multiple - (multiple)
        
        List<Student> s = q.list();
        
        for(Student st: s)
        {
        	System.out.println(st.getName());
        }
        
//        delete   video-22
        System.out.println("_________________________________________________________");
        
        Transaction tx = session.beginTransaction();
        
//        Query q1=session.createQuery("delete from Student as s where s.city=:c");	
        Query q1=session.createQuery("update Student as s set s.city=:c where s.name=:d");
        q1.setParameter("c", "Pune Park");
        q1.setParameter("d","Pratik");
        
        int r = q1.executeUpdate();
        tx.commit();
//        System.out.println("deleted"+r);
        System.out.println("updated"+r);
//        join query
        
        Query q3 = session.createQuery("select q.qid,q.que,a.ans from Question as q inner join q.ans1 as a");
        List<Object[]> l1=q3.getResultList();
        
        for(Object[] arr:l1)
        {
        	System.out.println(Arrays.toString(arr));
        }
        
        session.close();
        factory.close();
	}
}
