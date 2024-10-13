package com.hql;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HQLExample {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("com/hql/hibernate.cfg.xml");
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
        
//        first level cache v - 27
//        Student s=session.get(Student.class,45);   
////      session se asossiated hioti he firstlevelcache
//      
//      System.out.println(s.getName());
//      System.out.println("working something");
//      Student s2=session.get(Student.class,45);
//      System.out.println(s2.getName());
//      System.out.println(session.contains(s2));
//      video 28 second level cache
        
        factory.close();
	}
}
