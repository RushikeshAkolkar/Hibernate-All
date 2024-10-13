package com.pagination;

//video 23

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hql.Student;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/state/hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		Query<Student> q = s.createQuery("from Student");
		
		//implementing pagination using hibernate
		
		q.setFirstResult(0);
		
		q.setMaxResults(5);
		
		List<Student> list = q.list();
		
		for(Student s1 : list)
		{
			System.out.println("id  :"+s1.getId()+s1.getName()+"  :  "+s1.getCity());
		}
		
		s.close();
		factory.close();
		
	}
}
